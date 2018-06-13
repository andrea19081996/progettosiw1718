package apicella.bersani.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.controller.validator.AttivitaValidator;
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
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Responsabile responsabile = responsabileService.findByEmail(user.getUsername());
		
		attivita.setAllievi(new ArrayList<>());
		attivita.setCentro(responsabile.getCentro());
		attivitaService.save(attivita);
		model.addAttribute("attivita",attivita);
		return "confermaAggiuntaAttivita";
	}
}
