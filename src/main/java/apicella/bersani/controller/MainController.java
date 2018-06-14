package apicella.bersani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Responsabile;
import apicella.bersani.service.ResponsabileService;

/**
 * Solo per testare la struttura del database.
 */
@Controller
public class MainController {
	
	@Autowired 
	ResponsabileService responsabileService;
	
	@RequestMapping(value= {"/","/index"})
	protected String showHomePage(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Responsabile responsabile = responsabileService.findByEmail(user.getUsername());
		model.addAttribute("responsabile", responsabile);
		
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
