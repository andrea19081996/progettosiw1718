package apicella.bersani.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Centro;
import apicella.bersani.model.Responsabile;
import apicella.bersani.service.CentroService;

@Controller
public class ResponsabileController {
	
	@Autowired
	private CentroService centroService;

	@RequestMapping("/scegliAttivita")
	public String cerca(HttpSession session, Model model){
		
		Responsabile r= (Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}
		
		if(!r.getRuolo().equals("direttore")){
			return "erroreResponsabile";
		}
		
		List<Centro> centri = this.centroService.findAll();
		model.addAttribute("centri",centri);
		
		return "scegliCentro";
		
	}
	
}
