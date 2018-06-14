package apicella.bersani.controller;

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
			System.out.println("Nessun allievo");
			model.addAttribute("messaggioErrore", "Non e' presente nessun allievo con questa email.");
		}else	
		{
			System.out.println("Allievo trovato");
			model.addAttribute("messaggio", "E' stato trovato il seguente allievo gia' registrato.");
			model.addAttribute("allievoCercato", cercato);
		}
		
		return "controlloAllievoEsistente";
	}
	
	// Controller iniziale per uc2
	@RequestMapping("/cercaAllievo")
	public String prova2(HttpSession session, Model model) {
		return "controlloAllievoEsistente";
		
	}
	
	//UC1
	@RequestMapping("/registrazioneAllievo")
	public String prova1(HttpSession session, Model model) {
		model.addAttribute("allievo", new Allievo());
		return "registrazioneAllievo";
	}

	@RequestMapping(value="/makeRegistration", method=RequestMethod.POST)
	public String prova2(@Valid @ModelAttribute("allievo") Allievo allievo, Model model, BindingResult theBindingResult) {

		
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
		            return "confermaRegistrazione";
		        }
        }
  

		/*System.out.println("Binding resul " + theBindingResult);
		System.out.println("\n\n\n");

		if(theBindingResult.hasErrors()) {
			return "registrazioneAllievo";
		}else {

			
		return "confermaRegistrazione";*/
		
	}
}
