package apicella.bersani.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apicella.bersani.controller.validator.AllievoValidator;
import apicella.bersani.model.Allievo;
import apicella.bersani.service.AllievoService;

@Controller
public class AllievoController {

	@Autowired
	private AllievoService repository;

	@Autowired
	private AllievoValidator validator;

	// Controlla se un'allievo è gia presente nel database
	@RequestMapping("controllaAllievo")
	public String controllaAllievo(@RequestParam("email") String email, Model model) {

		Allievo cercato = repository.findByEmail(email);
		// Se non ho trovato l'allievo
		if(cercato==null)
		{
			model.addAttribute("messaggioErrore", "Non e' presente nessun allievo con questa email.");
		}else	
		{
			model.addAttribute("messaggio", "E' stato trovato il seguente allievo gia' registrato.");
			model.addAttribute("allievoCercato", cercato);
		}

		return "controlloAllievoEsistente";
	}

	// Controller iniziale per uc2
	@RequestMapping("/cercaAllievo")
	public String cercaAllievo(HttpSession session, Model model) {
		return "controlloAllievoEsistente";

	}

	//Caso d'uso UC1
	@RequestMapping("/registrazioneAllievo")
	public String registrazioneAllievo(HttpSession session, Model model) {
		model.addAttribute("allievo", new Allievo());
		return "registrazioneAllievo";
	}

	
	@RequestMapping(value="/makeRegistration", method=RequestMethod.POST)
	public String makeRegistration(@Valid @ModelAttribute("allievo") Allievo allievo, Model model, BindingResult theBindingResult) {

		this.validator.validate(allievo, theBindingResult);

		if(theBindingResult.hasErrors()) {
			return "registrazioneAllievo"; 
		} else {
			if (this.repository.alreadyExists(allievo)) {
				model.addAttribute("esiste", "L'allievo è già presente nel database");
				return "registrazioneAllievo";
			} 	else {
				this.repository.save(allievo);
				model.addAttribute("allievo",allievo);
				SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
				model.addAttribute("dataNascita", formatter.format(allievo.getDataNascita()));
				return "confermaRegistrazione";
			}
		}
	}
}
