package apicella.bersani.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicella.bersani.model.Attivita;
import apicella.bersani.model.Centro;
import apicella.bersani.repository.CentroRepository;

@Service
@Transactional
public class CentroService {

	@Autowired
	private CentroRepository repository;
	
	public List<Centro> findAll(){
		return (List<Centro>) this.repository.findAll();
	}
	
	public Centro findById(Long id){
		Optional<Centro> c = this.repository.findById(id);
		if(c.isPresent())
			return c.get();
		else
			return null;
	}

	public void save(Centro centro) {
		this.repository.save(centro);
		
	}
}
