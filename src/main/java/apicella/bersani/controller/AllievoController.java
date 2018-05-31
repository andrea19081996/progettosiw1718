package apicella.bersani.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apicella.bersani.model.Allievo;
import apicella.bersani.model.Responsabile;
import apicella.bersani.service.AllievoService;

@Controller
public class AllievoController {
	
	@Autowired
	AllievoService repository;
	
	@RequestMapping("controllaAllievo")
	public String controllaAllievo(@RequestParam("email") String email, Model model) {

		Allievo cercato = repository.findByEmail(email);
		if(cercato==null)
		{
			System.out.println("Nessun allievo");
			model.addAttribute("messaggioErrore", "Non � presente nessun allievo con questa email.");
		}else
		{
			System.out.println("Allievo trovato");
			model.addAttribute("messaggio", "E' stato trovato il seguente allievo gi� registrato.");
			model.addAttribute("allievoCercato", cercato.toHtmlString());
		}
		
		return "controlloAllievoEsistente";
	}
	
	@RequestMapping("/cercaAllievo")
	public String prova2(HttpSession session, Model model) {

		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}
		return "controlloAllievoEsistente";

	}
}
