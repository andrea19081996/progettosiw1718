package apicella.bersani.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicella.bersani.model.Allievo;
import apicella.bersani.repository.AllievoRepository;

@Service
@Transactional
public class AllievoService {

	@Autowired
	private AllievoRepository repository;
	
	public Allievo save(Allievo allievo) {
		return this.repository.save(allievo);
	}
	
	public Allievo findByEmail(String email)
	{
		return repository.findByEmail(email);
	}
	
	public void updateAttivita(Allievo a)
	{
		repository.save(a);
	}
	
	
	public boolean alreadyExists(Allievo allievo) {
		Allievo allievi = this.repository.findByEmail(allievo.getEmail());
		if (allievi!=null)
			return true;
		else 
			return false;
	}
	
	
}
