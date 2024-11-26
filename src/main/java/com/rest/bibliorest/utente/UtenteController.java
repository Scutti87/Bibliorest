package com.rest.bibliorest.utente;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/utente")
public class UtenteController {

	private IUtenteService us;

	public UtenteController(IUtenteService us) {
		this.us = us;
	}

	@RequestMapping("cerca/{id}")
	public UtenteDto getUtenteById(@PathVariable("id") long id) {

		UtenteDto a = us.getUtenteById(id);

		return a;
	}

	@RequestMapping("lista")
	public Iterable<UtenteDto> getListaUtenti() {

		List<UtenteDto> lista = us.getListaUtenti();

		return lista;
	}
}
