package apicella.bersani.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicella.bersani.model.Responsabile;
import apicella.bersani.repository.ResponsabileRepository;

@Service
@Transactional
public class ResponsabileService {

	@Autowired
	ResponsabileRepository repository;
	
	public Responsabile findByEmail(String email)
	{
		return repository.findByEmail(email);
	}
	
	public void save(Responsabile r)
	{
		repository.save(r);
	}
}
