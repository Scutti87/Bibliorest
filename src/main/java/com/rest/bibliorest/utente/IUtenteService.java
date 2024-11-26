package com.rest.bibliorest.utente;

import java.util.List;

public interface IUtenteService {

	UtenteDto getUtenteById(long id);

	List<UtenteDto> getListaUtenti();
}
