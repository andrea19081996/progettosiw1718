package apicella.bersani;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import apicella.bersani.service.AllievoService;
import apicella.bersani.service.CentroService;
import apicella.bersani.service.ResponsabileService;

@SpringBootApplication
public class ProgettoSiw1718Application extends SpringBootServletInitializer {
	
	@Autowired
	ResponsabileService responsabileService;
	
	//usati per inizializzazione
	@Autowired
	private AllievoService allievoService;
	
	@Autowired
	private CentroService centroService;

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSiw1718Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProgettoSiw1718Application.class);
	}

	@PostConstruct
	public void init()
	{	

		//caso d'inizializzazione
//		Responsabile r = new Responsabile();
//		r.setEmail("prova@prova.it");
//		r.setPassword("prova");
//		Centro centro = new Centro();
//		centro.setAttivita(new LinkedList<Attivita>());
//		centro.setEmail("prova");
//		centro.setIndirizzo("indirizzo");
//		centro.setNome("Centro");
//		centro.setNumMax(100);
//		centro.setTelefono("123456789");
//		r.setCentro(centro);
//		r.setRuolo("responsabile");
//		centroService.save(centro);
//		responsabileService.save(r);
//		
//		Responsabile d = new Responsabile();
//		d.setEmail("direttore@direttore.it");
//		d.setPassword("prova");
//		d.setRuolo("direttore");
//		d.setCentro(centro);
//		responsabileService.save(d);

	}
}
