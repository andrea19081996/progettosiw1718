package apicella.bersani.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import apicella.bersani.model.Responsabile;
import apicella.bersani.service.CentroService;
import apicella.bersani.service.ResponsabileService;

/**
 * Solo per testare la struttura del database.
 */
@Controller
public class MainController {

	@Autowired 
	ResponsabileService responsabileService;
	
	@Autowired
	CentroService centroService;

	private static String authorizationRequestBaseUri = "oauth2/authorization";

	Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;

	@RequestMapping(value= {"/","/index"})
	protected String showHomePage(HttpSession session, HttpServletRequest request,Model model) {
		if(session.getAttribute("responsabile") == null) {
			Responsabile responsabile = null;
			try {
				// Form login
				UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				responsabile = responsabileService.findByEmail(user.getUsername());
				session.setAttribute("img","/images/user.png");
			}catch(Exception e)
			{
				// oAuth login
				DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				responsabile = responsabileService.findByEmail(user.getEmail());
				session.setAttribute("img",user.getPicture());
				
				// Se non è registrato nel database
				if(responsabile==null)
					try {
						request.logout();
						getMetodiDiLogin();
						model.addAttribute("urls", oauth2AuthenticationUrls);
						return "login";
					} catch (ServletException e1) {
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			session.setAttribute("email",responsabile.getEmail());
			session.setAttribute("responsabile",responsabile);
		}
		
		return "index";
	}


	@GetMapping("/login")
	public String showLogin(Model model) {
		getMetodiDiLogin();
		model.addAttribute("urls", oauth2AuthenticationUrls);
		return "login";
	}
	
	private void getMetodiDiLogin() {
		Iterable<ClientRegistration> clientRegistrations = null;
		ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository).as(Iterable.class);
		if (type != ResolvableType.NONE && 
				ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
			clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
		}

		clientRegistrations.forEach(registration -> 
		oauth2AuthenticationUrls.put(registration.getClientName(), 
				authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
	}


	@RequestMapping("/errore")
	public String mostraPaginaErrore() {
		return "errore";
	}


}
