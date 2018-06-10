package apicella.bersani.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Azienda;
import apicella.bersani.model.Responsabile;

/**
 * Solo per testare la struttura del database.
 */
@Controller
public class MainController {
	
	@RequestMapping(value= {"/","/index"})
	protected String showHomePage(HttpSession session) {
		Azienda azienda = (Azienda) session.getAttribute("azienda");
		if(azienda==null)
		{	azienda = new Azienda();
			session.setAttribute("azienda", azienda);
		}
		
		return "index";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/errore")
	public String mostraPaginaErrore() {
		return "errore";
	}
	

}
