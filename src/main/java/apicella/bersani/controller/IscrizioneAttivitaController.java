package apicella.bersani.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
import apicella.bersani.service.ResponsabileService;

@Controller
public class IscrizioneAttivitaController {

	@Autowired
	AllievoService allievoService;

	@Autowired
	AttivitaService attivitaService;
	
	@Autowired 
	ResponsabileService responsabileService;

	// Controller iniziale per uc3. Controlla se il responsaible è loggato e mostra la view iniziale
	@RequestMapping("/iscriviAllievo")
	public String mostraIscrizioneAllievo(HttpSession session, Model model)
	{
		return "iscrizioneAllievoAttivita";
	}

	// Se il resposnabile sceglie di usare un allievo già esistente, fornisce l'email e l'allievo viene recuperato dal database.
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
		// Prendo il resposanbile dalla sessione
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Responsabile r = responsabileService.findByEmail(user.getUsername());

		Centro c = r.getCentro();
		// Prendo tutte le attività odierne e controllo la capienza del centro.
		List<Attivita> attivita = attivitaService.getAttivitaOdierne(c);
		int postiOccupati = 0;
		for(Attivita att : attivita)
			postiOccupati = postiOccupati + att.getAllievi().size();

		if(postiOccupati>=c.getNumMax())
		{
			// Se ho raggiunto la capienza masssima allora non posso proseguire
			model.addAttribute("messaggioErrore", "Non è possibile eseguire un'iscrizione in quanto è stata raggiunta la capienza massima per qesto centro.");
			return "errore";
		}
		model.addAttribute("postiDisponibili", c.getNumMax()-postiOccupati);
		model.addAttribute("listaAttivita",attivita);
		session.setAttribute("allievoSelezionato", trovato);
		return "selezionaAttivita";
	}

	// Iscrive un allievo ad un'attività identificata da "id"
	@RequestMapping("iscrivi/{id}")
	public String iscrivi(@PathVariable Long id, HttpSession session, Model model) 
	{
		Allievo allievo = (Allievo) session.getAttribute("allievoSelezionato");
		// Tolgo l'allievo selezionato dalla sessione
		session.removeAttribute("allievoSelezionato");
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
			}catch(InvalidDataAccessApiUsageException e)
			{
				// L'allievo è gia registrato
				e.printStackTrace();
				model.addAttribute("messaggioErrore", "L'allievo e' gia' regstrato a questa attività.");
				return "errore";
			}catch(Exception e)
			{
				// Altro errore
				e.printStackTrace();
				return "errore";
			}
			
		}else
		{
			model.addAttribute("messaggioErrore", "Non è possibile eseguire l'iscrizione a questa attività.");
			return "errore";
		}

		return "confermaIscrizione";
	}

}
