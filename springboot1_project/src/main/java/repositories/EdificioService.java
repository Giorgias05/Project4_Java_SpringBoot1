package repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Edificio;
import exceptions.ItemNotFoundException;

@Service
public class EdificioService {
	@Autowired
	private EdificioRepository usersRepo;

	public void create(Edificio e) {
//logica custom addizionale
		usersRepo.save(e);
	}

	public List<Edificio> find() {
		return usersRepo.findAll();
	}

	public Edificio findByNameIgnoreCase(String name) throws ItemNotFoundException {
		return usersRepo.findByNameIgnoreCase(name).orElseThrow(() -> new ItemNotFoundException(name));
	}

	public Edificio findById(Long id) {
		return usersRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	public void findByIdAndUpdate(Long id, Edificio e) throws ItemNotFoundException {
		Edificio found = this.findById(id);
		found.setId(e.getId());
		found.setNome(e.getNome());
		found.setIndirizzo(e.getIndirizzo());
		found.setCittà(e.getCittà());
		found.setPostazioni(e.getPostazioni());

	}

	public void findByIdAndDelete(Long id) {
		Edificio found = this.findById(id);
		usersRepo.delete(found);
	}

	public long count() {
		return usersRepo.count();
	}
}
