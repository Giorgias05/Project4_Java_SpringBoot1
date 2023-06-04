package repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Postazione;
import exceptions.ItemNotFoundException;

@Service
public class PostazioneService {
	@Autowired
	private PostazioneRepository usersRepo;

	public void create(Postazione p) {
//logica custom addizionale
		usersRepo.save(p);
	}

	public List<Postazione> find() {
		return usersRepo.findAll();
	}

	public Postazione findByPostazioneIgnoreCase(String codice) throws ItemNotFoundException {
		return usersRepo.findByNameIgnoreCase(codice).orElseThrow(() -> new ItemNotFoundException(codice));
	}

	public Postazione findById(String id) {
		return usersRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	public void findByIdAndUpdate(String id, Postazione p) throws ItemNotFoundException {
		Postazione found = this.findById(id);
		found.setCodice(p.getCodice());
		found.setDescrizione(p.getDescrizione());
		found.setTipo(p.getTipo());
		found.setMaxOccupanti(p.getMaxOccupanti());
		found.setEdificio(p.getEdificio());
		found.setPrenotazioni(p.getPrenotazioni());

	}

	public void findByIdAndDelete(String id) {
		Postazione found = this.findById(id);
		usersRepo.delete(found);
	}

	public long count() {
		return usersRepo.count();
	}
}
