package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Utente;

public interface UtenteRepository extends JpaRepository<Utente, String> {
	Optional<Utente> findByNameIgnoreCase(String name);

	List<Utente> findByNameAndSurname(String name, String surname);
}
