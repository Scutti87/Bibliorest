package com.rest.bibliorest.autore;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AutoreServiceImpl implements IAutoreService {

	private final ModelMapper mm;
	private final IAutoreRepository ar;

	@Autowired
	public AutoreServiceImpl(ModelMapper mm, IAutoreRepository ar) {
		this.mm = mm;
		this.ar = ar;
	}

	@Override
	public AutoreDto getAutoreById(long id) {

		Autore a = ar.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Autore con id %d non presente in db", id)));

		return mm.map(a, AutoreDto.class);
	}

	@Override
	public List<AutoreDto> getListaAutori() {

		List<AutoreDto> listaDto = new ArrayList<AutoreDto>();
		List<Autore> lista = ar.findAll();
		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun autore presente in db");
		}

		lista.forEach(a -> listaDto.add(mm.map(a, AutoreDto.class)));

		return listaDto;
	}

	@Override
	public List<AutoreDto> getListaAutoriByEditore(long id) {

		List<AutoreDto> listaDto = new ArrayList<AutoreDto>();
		List<Autore> lista = ar.getListaAutoriByEditore(id);
		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun autore presente in db con id editore " + id);
		}

		lista.forEach(a -> listaDto.add(mm.map(a, AutoreDto.class)));

		return listaDto;
	}

}
