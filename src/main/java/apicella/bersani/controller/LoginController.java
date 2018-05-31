package apicella.bersani.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Responsabile;
import apicella.bersani.repository.ResponsabileRepository;
import apicella.bersani.service.ResponsabileService;

@Controller
public class LoginController {

	@Autowired
	ResponsabileService responsabileService;
	
	@RequestMapping("/makeLogin")
	public String processLogin(HttpSession session, @ModelAttribute("responsabile") Responsabile responsabile, Model model)
	{
		String next;
		Responsabile result = makeLogin(responsabile);
		
		if(result!=null)
		{
			session.setAttribute("responsabileLoggato", result);
			next = "index";
		}
		else
		{
			next="login";
			model.addAttribute("error", "Email o password errati");
		}
		
		System.out.println("LoginController: vado a " + next);
			
		return next;
		
	}
	
	public Responsabile makeLogin(Responsabile responsabileDaLoggare) {
		System.out.println("Inizio makeLogin");
		Responsabile result;
		
		Responsabile r = responsabileService.findByEmail(responsabileDaLoggare.getEmail());
		
		if(r!=null && r.checkLogin(responsabileDaLoggare.getPassword()))
		{
			result = r;
			
		}else
		{
			result = null;
		}
	
		return result;
	}
	
	
}
