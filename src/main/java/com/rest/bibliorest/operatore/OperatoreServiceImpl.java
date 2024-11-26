package com.rest.bibliorest.operatore;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OperatoreServiceImpl implements IOperatoreService {

	private ModelMapper mm;
	private IOperatoreRepository or;

	public OperatoreServiceImpl(ModelMapper mm, IOperatoreRepository or) {
		this.mm = mm;
		this.or = or;
	}

	@Override
	public OperatoreDto getOperatoreById(long id) {

		Operatore a = or.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Operatore con id %d non presente in db", id)));

		return mm.map(a, OperatoreDto.class);
	}

	@Override
	public List<OperatoreDto> getListaOperatori() {

		List<OperatoreDto> listaDto = new ArrayList<OperatoreDto>();
		List<Operatore> lista = or.findAll();
		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun Operatore presente in db");
		}

		lista.forEach(a -> listaDto.add(mm.map(a, OperatoreDto.class)));

		return listaDto;
	}
}
