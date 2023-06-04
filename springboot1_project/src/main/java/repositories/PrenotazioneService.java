package repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Prenotazione;
import exceptions.ItemNotFoundException;

@Service
public class PrenotazioneService {
	@Autowired
	private PrenotazioneRepository usersRepo;

	public void create(Prenotazione p) {
//logica custom addizionale
		usersRepo.save(p);
	}

	public List<Prenotazione> find() {
		return usersRepo.findAll();
	}

	public Prenotazione findById(Long id) {
		return usersRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	public void findByIdAndUpdate(Long id, Prenotazione p) throws ItemNotFoundException {
		Prenotazione found = this.findById(id);
		found.setId(p.getId());
		found.setData(p.getData());
		found.setPostazione(p.getPostazione());
		found.setUtente(p.getUtente());

	}

	public void findByIdAndDelete(Long id) {
		Prenotazione found = this.findById(id);
		usersRepo.delete(found);
	}

	public long count() {
		return usersRepo.count();
	}
}
