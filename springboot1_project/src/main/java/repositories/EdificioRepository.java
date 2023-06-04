package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
	Optional<Edificio> findByNameIgnoreCase(String name);

	List<Edificio> findByNameAndSurname(String name, String surname);
}
