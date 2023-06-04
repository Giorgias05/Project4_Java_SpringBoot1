package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

}
