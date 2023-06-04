package repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Utente;
import exceptions.ItemNotFoundException;

@Service
public class UtenteService {
	@Autowired
	private UtenteRepository usersRepo;

	public void create(Utente u) {
//logica custom addizionale
		usersRepo.save(u);
	}

	public List<Utente> find() {
		return usersRepo.findAll();
	}

	public Utente findByNameIgnoreCase(String name) throws ItemNotFoundException {
		return usersRepo.findByNameIgnoreCase(name).orElseThrow(() -> new ItemNotFoundException(name));
	}

	public Utente findById(String id) {
		return usersRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	public void findByIdAndUpdate(String id, Utente u) throws ItemNotFoundException {
		Utente found = this.findById(id);
		found.setUsername(u.getUsername());
		found.setNomeCompleto(u.getNomeCompleto());
		found.setEmail(u.getEmail());
		found.setPrenotazioni(u.getPrenotazioni());

	}

	public void findByIdAndDelete(String id) {
		Utente found = this.findById(id);
		usersRepo.delete(found);
	}

	public long count() {
		return usersRepo.count();
	}
}
