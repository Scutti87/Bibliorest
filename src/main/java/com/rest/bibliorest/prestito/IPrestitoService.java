package com.rest.bibliorest.prestito;

import java.util.List;

public interface IPrestitoService {

	PrestitoDto getPrestitoById(long id);

	List<PrestitoDto> getListaPrestiti();
	
	PrestitoDto prestaLibro(PrestitoDto p);

	boolean restituisciLibro(PrestitoDto p);
}
