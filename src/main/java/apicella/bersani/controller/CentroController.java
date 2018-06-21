package apicella.bersani.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Attivita;
import apicella.bersani.model.Centro;
import apicella.bersani.service.CentroService;

@Controller
public class CentroController {

	@Autowired
	private CentroService centroService;
	
	@RequestMapping("/centro/{id}")
	public String cerca(HttpSession session, Model model, @PathVariable Long id){
		
		Centro centro = this.centroService.findById(id);
		List<Attivita> attività = centro.getAttivita();
		model.addAttribute("attivita", attività);
		
		return "show-attivita";
		
	}
}
