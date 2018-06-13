package apicella.bersani.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Centro;
import apicella.bersani.model.Responsabile;
import apicella.bersani.service.CentroService;
import apicella.bersani.service.ResponsabileService;

@Controller
public class ResponsabileController {
	
	@Autowired
	private CentroService centroService;
	
	@Autowired 
	ResponsabileService responsabileService;

	@RequestMapping("/scegliAttivita")
	public String cerca(HttpSession session, Model model){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Responsabile r = responsabileService.findByEmail(user.getUsername());
		
		if(!r.getRuolo().equals("direttore")){
			return "erroreResponsabile";
		}
		
		List<Centro> centri = this.centroService.findAll();
		model.addAttribute("centri",centri);
		
		return "scegliCentro";
		
	}
	
}