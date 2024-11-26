package com.rest.bibliorest.autore;

import java.util.List;

public interface IAutoreService {
	
	AutoreDto getAutoreById(long id);
	
	List<AutoreDto> getListaAutori();
	
	List<AutoreDto> getListaAutoriByEditore(long id);

}
