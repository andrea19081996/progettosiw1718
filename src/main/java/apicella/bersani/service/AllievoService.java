package apicella.bersani.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicella.bersani.model.Allievo;
import apicella.bersani.repository.AllievoRepository;

@Service
@Transactional
public class AllievoService {

	@Autowired
	AllievoRepository repository;
	
	public Allievo findByEmail(String email)
	{
		return repository.findByEmail(email);
	}
}
