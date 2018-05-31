package apicella.bersani.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Azienda;
import apicella.bersani.model.Responsabile;

/**
 * Solo per testare la struttura del database.
 */
@Controller
public class Main {
	
	@RequestMapping(value= {"/","/index"})
	protected String showHomePage(HttpSession session) {
		Azienda azienda = (Azienda) session.getAttribute("azienda");
		if(azienda==null)
		{	azienda = new Azienda();
			session.setAttribute("azienda", azienda);
		}
		
		return "index";
	}
	
	@RequestMapping("/login")
	protected String showLoginPage(Model model) {
		model.addAttribute("responsabile", new Responsabile());
		return "login";
	}
	
	@RequestMapping("/nuova_pagina")
	public String nuovaPagina(Model model) {
		return "nuova_pagina";
	}
	

}
