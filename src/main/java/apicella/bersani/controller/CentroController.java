package apicella.bersani.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Centro;
import apicella.bersani.service.AttivitaService;
import apicella.bersani.service.CentroService;

@Controller
public class CentroController {

	@Autowired
	private AttivitaService attivitaService;
	
	@Autowired
	private CentroService centroService;
	
	@RequestMapping("/centro/{id}")
	public String cerca(HttpSession session, Model model, @PathVariable Long id){
		
		Centro centro = this.centroService.findById(id);
		this.attivitaService.findByCentro(centro);
		
		return "scegliCentro";
		
	}
}
