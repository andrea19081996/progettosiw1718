package apicella.bersani.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import apicella.bersani.model.Attivita;
import apicella.bersani.model.Centro;

public interface AttivitaRepository extends CrudRepository<Attivita,Long> {

	public List<Attivita> findByCentro(Centro c);
	
	public List<Attivita> findByCentroAndData(Centro c, Date data);
	
	public boolean existsByNomeAndDataAndOrario(String nome, Date data, Date orario);
}
