package apicella.bersani.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicella.bersani.model.Attivita;
import apicella.bersani.model.Centro;
import apicella.bersani.repository.AttivitaRepository;

@Service
@Transactional
public class AttivitaService {

	@Autowired
	AttivitaRepository repository;
	
	public List<Attivita> findByCentro(Centro centro)
	{
		return repository.findByCentro(centro);
	}
	
	public List<Attivita> getAttivitaOdierne(Centro centro)
	{
		return repository.findByCentroAndData(centro, Calendar.getInstance().getTime());
	}
	
	public Attivita findById(Long id) 
	{
		Optional<Attivita> a = repository.findById(id);
		if(a.isPresent())
			return a.get();
		else
			return null;
	}
	
	
}
