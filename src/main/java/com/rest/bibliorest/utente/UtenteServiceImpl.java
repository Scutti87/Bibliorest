package com.rest.bibliorest.utente;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UtenteServiceImpl implements IUtenteService {

	private ModelMapper mm;
	private IUtenteRepository ur;

	public UtenteServiceImpl(ModelMapper mm, IUtenteRepository ur) {
		this.mm = mm;
		this.ur = ur;
	}

	@Override
	public UtenteDto getUtenteById(long id) {

		Utente a = ur.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Utente con id %d non presente in db", id)));

		return mm.map(a, UtenteDto.class);
	}

	@Override
	public List<UtenteDto> getListaUtenti() {

		List<UtenteDto> listaDto = new ArrayList<UtenteDto>();
		List<Utente> lista = ur.findAll();
		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun Utente presente in db");
		}

		lista.forEach(a -> listaDto.add(mm.map(a, UtenteDto.class)));

		return listaDto;
	}
}
