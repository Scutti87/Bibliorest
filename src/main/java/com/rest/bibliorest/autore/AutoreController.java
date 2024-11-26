package com.rest.bibliorest.autore;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/autore")
public class AutoreController {

	private IAutoreService as;

	public AutoreController(IAutoreService as) {
		this.as = as;
	}
	
	@RequestMapping("cerca/{id}")
	public AutoreDto getAutoreById(@PathVariable("id") long id) {
		
		AutoreDto a = as.getAutoreById(id);
		
		return a;
	}
	
	@RequestMapping("lista")
	public Iterable<AutoreDto> getListaAutori() {
		
		List<AutoreDto> lista = as.getListaAutori();
		
		return lista;
	}
	
	@RequestMapping("listaByEditore/{id}")
	public Iterable<AutoreDto> getListaAutoriByEditore(@PathVariable("id") long id) {
		
		List<AutoreDto> lista = as.getListaAutoriByEditore(id);
		
		return lista;
	}
	
}
