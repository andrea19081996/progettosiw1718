package apicella.bersani.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import apicella.bersani.model.Attivita;
import apicella.bersani.model.Centro;

public interface AttivitaRepository extends CrudRepository<Attivita,Long> {

	public List<Attivita> findByCentro(Centro c);
}
