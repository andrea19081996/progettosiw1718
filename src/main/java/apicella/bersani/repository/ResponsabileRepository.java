package apicella.bersani.repository;

import org.springframework.data.repository.CrudRepository;

import apicella.bersani.model.Responsabile;

public interface ResponsabileRepository extends CrudRepository<Responsabile,Long> {

	public Responsabile findByEmail(String email);
}
