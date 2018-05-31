package apicella.bersani.repository;

import org.springframework.data.repository.CrudRepository;

import apicella.bersani.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo,Long> {

	public Allievo findByEmail(String email);
}
