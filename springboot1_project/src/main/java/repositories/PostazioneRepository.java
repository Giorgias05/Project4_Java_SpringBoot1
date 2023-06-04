package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Postazione;

public interface PostazioneRepository extends JpaRepository<Postazione, String> {
	Optional<Postazione> findByNameIgnoreCase(String name);

	List<Postazione> findByNameAndSurname(String name, String surname);
}
