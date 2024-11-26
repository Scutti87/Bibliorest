package com.rest.bibliorest.libro;

import java.util.List;

public interface ILibroService {

	LibroDto getLibroById(long id);

	List<LibroDto> getListaLibri();
	
	List<LibroDto> getListaLibriByAutore(long id);
	
	List<LibroDto> getListaLibriByEditore(long id);
	
	List<LibroDto> getListaLibriDisponibili();
	
	boolean aggiorna(LibroDto l);
}
