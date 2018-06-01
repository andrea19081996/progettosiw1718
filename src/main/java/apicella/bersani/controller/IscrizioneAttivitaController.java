package apicella.bersani.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apicella.bersani.model.Allievo;
import apicella.bersani.model.Attivita;
import apicella.bersani.model.Centro;
import apicella.bersani.model.Responsabile;
import apicella.bersani.service.AllievoService;
import apicella.bersani.service.AttivitaService;

@Controller
public class IscrizioneAttivitaController {

	@Autowired
	AllievoService allievoService;

	@Autowired
	AttivitaService attivitaService;

	@RequestMapping("/iscriviAllievo")
	public String mostraIscrizioneAllievo(HttpSession session, Model model)
	{
		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");

		if (r==null) {
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}
		return "iscrizioneAllievoAttivita";
	}

	@RequestMapping("selezionaAllievoEsistente")
	public String selezionaAllievoEsistente(@RequestParam("email") String email, Model model,HttpSession session)
	{
		Allievo trovato = allievoService.findByEmail(email);
		if(trovato==null)
		{
			model.addAttribute("erroreSelezionaAllievo", "Nessun allievo trovato con questa email.");
			return "iscrizioneAllievoAttivita";
		}

		// Se trovo l'allievo seleziono tutte le attività del centro.
		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}

		Centro c = r.getCentro();
		List<Attivita> attivita = attivitaService.findByCentro(c);
		model.addAttribute("listaAttivita",attivita);
		session.setAttribute("allievoSelezionato", trovato);
		return "selezionaAttivita";
	}

	@RequestMapping("iscrivi/{id}")
	public String iscrivi(@PathVariable Long id, HttpSession session) 
	{
		Allievo allievo = (Allievo) session.getAttribute("allievoSelezionato");
		Attivita attivita = attivitaService.findById(id);
		if(allievo!=null && attivita!=null)
		{
			System.out.println("Iscrivi: attivita e allievo trovati.");
			// Iscrivo all'attivita
			allievo.addAttivita(attivita);
			System.out.println("Iscrivi: ho aggiunto l'attivita all'allievo");
			attivita.addAllievo(allievo);
			System.out.println("Iscrivi: ho aggiunto l'allievo all'attivita");
			try {
				allievoService.updateAttivita(allievo);
			}catch(Exception e)
			{
				return "errore";
			}
			// Tolgo l'allievo selezionato dalla sessione
			session.removeAttribute("allievoSelezionato");
		}else
		{
			return "errore";
		}

		return "confermaIscrizione";
	}

}
