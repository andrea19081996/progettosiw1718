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
import org.springframework.web.bind.annotation.RequestMethod;

import apicella.bersani.model.Allievo;
import apicella.bersani.model.Responsabile;

@Controller
public class GeneralController {





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
