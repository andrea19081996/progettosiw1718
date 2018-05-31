package apicella.bersani.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicella.bersani.model.Customer;
import apicella.bersani.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository repository;
	
	public void save(Customer c)
	{
		repository.save(c);
	}
}
