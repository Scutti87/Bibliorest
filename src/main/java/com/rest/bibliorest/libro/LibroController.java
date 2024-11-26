package com.rest.bibliorest.libro;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/libro")
public class LibroController {

	private ILibroService ls;

	public LibroController(ILibroService ls) {
		this.ls = ls;
	}
	
	@GetMapping("cerca/{id}")
	public LibroDto getLibroById(@PathVariable("id") long id) {
		
		LibroDto a = ls.getLibroById(id);
		
		return a;
	}
	
	@RequestMapping("lista")
	public Iterable<LibroDto> getListaLibri() {
		
		List<LibroDto> lista = ls.getListaLibri();
		
		return lista;
	}
	
	@RequestMapping("listaByAutore/{id}")
	public Iterable<LibroDto> getListaLibriByAutore(@PathVariable("id") long id) {
		
		List<LibroDto> lista = ls.getListaLibriByAutore(id);
		
		return lista;
	}
	
	@RequestMapping("listaByEditore/{id}")
	public Iterable<LibroDto> getListaLibriByEditore(@PathVariable("id") long id) {
		
		List<LibroDto> lista = ls.getListaLibriByEditore(id);
		
		return lista;
	}
	
	@RequestMapping("listaDisponibili")
	public Iterable<LibroDto> getListaLibriDisponibili() {
		
		List<LibroDto> lista = ls.getListaLibriDisponibili();
		
		return lista;
	}
	
	@RequestMapping(value = "aggiorna/{id}/{idEditore}", method = RequestMethod.PUT)
	public LibroDto aggiornaLibro(@PathVariable("idEditore") long idEditore, @PathVariable("id") long id, @Valid @RequestBody LibroDto l) {
		
		l.setIdEditore(idEditore);
		l.setId(id);
		ls.aggiorna(l);
		
		return ls.getLibroById(id);
	}
}
