package apicella.bersani.repository;

import org.springframework.data.repository.CrudRepository;

import apicella.bersani.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
