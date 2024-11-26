package com.rest.bibliorest.editore;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EditoreServiceImpl implements IEditoreService {

	private ModelMapper mm;
	private IEditoreRepository er;

	@Autowired
	public EditoreServiceImpl(ModelMapper mm, IEditoreRepository er) {
		this.mm = mm;
		this.er = er;
	}

	@Override
	public EditoreDto getEditoreById(long id) {

		Editore a = er.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Editore con id %d non presente in db", id)));

		return mm.map(a, EditoreDto.class);
	}

	@Override
	public List<EditoreDto> getListaEditori() {

		List<EditoreDto> listaDto = new ArrayList<EditoreDto>();
		List<Editore> lista = er.findAll();
		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun editore presente in db");
		}

		lista.forEach(a -> listaDto.add(mm.map(a, EditoreDto.class)));

		return listaDto;
	}

}
