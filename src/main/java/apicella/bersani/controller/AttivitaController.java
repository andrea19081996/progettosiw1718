package apicella.bersani.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Attivita;
import apicella.bersani.model.Responsabile;
import apicella.bersani.service.AttivitaService;

@Controller
public class AttivitaController {
	
	@Autowired
	AttivitaService attivitaService;

	@RequestMapping("/nuovaAttivita")
	public String mostraPaginaAggiuntaAttivita(HttpSession session, Model model) {
		Responsabile responsabile = (Responsabile) session.getAttribute("responsabileLoggato");
		
		if(responsabile == null)
		{	
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}
		Attivita attivita = new Attivita();
		
		model.addAttribute("attivita", attivita);
		return "nuovaAttivita";
	}
	
	@RequestMapping("aggiungiAttivita")
	public String aggiungiNuovaAttivita(@ModelAttribute("attivita") Attivita attivita, HttpSession session, Model model)
	{
		Responsabile responsabile = (Responsabile) session.getAttribute("responsabileLoggato");
		
		if(responsabile == null)
		{	
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}

		attivita.setAllievi(new ArrayList<>());
		attivita.setCentro(responsabile.getCentro());
		attivitaService.save(attivita);
		model.addAttribute("attivita",attivita);
		return "confermaAggiuntaAttivita";
	}
}
