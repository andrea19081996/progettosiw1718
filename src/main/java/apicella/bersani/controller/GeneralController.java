package apicella.bersani.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Allievo;
import apicella.bersani.model.Responsabile;

@Controller
public class GeneralController {


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//per controllare datA nella form
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

		//togliere spazi bianchi nelle string
		StringTrimmerEditor stringTrimmerEditor= new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/registrazioneAllievo")
	public String prova1(HttpSession session, Model model) {

		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");

		if (r==null) {
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}
		
		model.addAttribute("allievo", new Allievo());
		return "registrazioneAllievo";

	}

	@RequestMapping("/makeRegistration")
	public String prova2(@Valid @ModelAttribute("allievo") Allievo allievo, BindingResult theBindingResult) {


		System.out.println("Binding resul " + theBindingResult);
		System.out.println("\n\n\n");

		if(theBindingResult.hasErrors()) {
			return "registrazioneAllievo";
		}else {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto-siw-unit");
			EntityManager em = emf.createEntityManager(); 
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			
			em.persist(allievo);
			
			tx.commit();
			if(em!=null)
				em.close();
			if(emf!=null)
				emf.close();
			
		return "confermaRegistrazione";
		}
		
		
	}





	@RequestMapping("/secondCase")
	public String prova2(HttpSession session, Model model) {

		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}
		return "controlloAllievoEsistente";

	}

	@RequestMapping("/thirthCase")
	public String prova3(HttpSession session, Model model) {

		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}
		return "prova3";

	}

	@RequestMapping("/fourthCase")
	public String prova4(HttpSession session, Model model) {

		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}
		return "prova4";

	}

	@RequestMapping("/fivethCase")
	public String prova5(HttpSession session, Model model) {

		Responsabile r=(Responsabile) session.getAttribute("responsabileLoggato");
		if (r==null) {
			model.addAttribute("responsabile", new Responsabile());
			return "login";
		}
		return "prova5";

	}

}
