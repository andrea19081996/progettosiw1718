package apicella.bersani.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.controller.validator.AttivitaValidator;
import apicella.bersani.model.Allievo;
import apicella.bersani.model.Attivita;
import apicella.bersani.model.Responsabile;
import apicella.bersani.service.AttivitaService;
import apicella.bersani.service.ResponsabileService;

@Controller
public class AttivitaController {
	
	@Autowired
	AttivitaService attivitaService;
	
	@Autowired
	AttivitaValidator validator;
	
	@Autowired
	ResponsabileService responsabileService;
	

	@RequestMapping("/nuovaAttivita")
	public String mostraPaginaAggiuntaAttivita(HttpSession session, Model model) {
		Attivita attivita = new Attivita();
		
		model.addAttribute("attivita", attivita);
		return "nuovaAttivita";
	}
	
	@RequestMapping("aggiungiAttivita")
	public String aggiungiNuovaAttivita(@ModelAttribute("attivita") Attivita attivita, BindingResult bindingResult, HttpSession session, Model model)
	{
		this.validator.validate(attivita, bindingResult);
		if(attivitaService.alreadyExists(attivita)) {
			model.addAttribute("errore", "Questa attiivita' e' gia' presente nell'elenco.");
			return "nuovaAttivita";
		}
		
		System.out.println(bindingResult.getAllErrors());
		if(bindingResult.hasErrors())
			return "nuovaAttivita";
		
		Responsabile responsabile = responsabileService.findByEmail((String) session.getAttribute("email"));
		
		attivita.setAllievi(new ArrayList<>());
		attivita.setCentro(responsabile.getCentro());
		attivitaService.save(attivita);
		model.addAttribute("attivita",attivita);
		SimpleDateFormat dateFormatter =new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat timeFormatter=new SimpleDateFormat("HH:mm");
		String data = dateFormatter.format(attivita.getData());
		String orario = timeFormatter.format(attivita.getOrario());
		model.addAttribute("data", data);
		model.addAttribute("orario", orario);
		return "confermaAggiuntaAttivita";
	}
	
	
	//UC5
	
	@RequestMapping("/centro/attivita/{id}")
	public String sceltaAttivita(Model model, @PathVariable("id") Long id) {
		
		Attivita attivita= this.attivitaService.findById(id);
		List<Allievo> allievi = attivita.getAllievi();
		
		model.addAttribute("allievi", allievi);
		model.addAttribute("totale", allievi.size());
		
		return "show-all-allevi-in-attivita";
		
	}
}
