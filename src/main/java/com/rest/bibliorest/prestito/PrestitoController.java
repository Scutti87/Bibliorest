package com.rest.bibliorest.prestito;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/prestito")
public class PrestitoController {

	private IPrestitoService ps;

	public PrestitoController(IPrestitoService ps) {
		this.ps = ps;
	}
	
	@RequestMapping("cerca/{id}")
	public PrestitoDto getPrestitoById(@PathVariable("id") long id) {

		PrestitoDto a = ps.getPrestitoById(id);

		return a;
	}

	@RequestMapping("lista")
	public Iterable<PrestitoDto> getListaPrestiti() {

		List<PrestitoDto> lista = ps.getListaPrestiti();

		return lista;
	}
	
	@RequestMapping(value = "prestaLibro", method = RequestMethod.POST)
	public PrestitoDto prestaLibro(@Valid @RequestBody PrestitoDto p) {

		PrestitoDto pre = ps.prestaLibro(p);

		return pre;
	}
	
	@RequestMapping(value = "restituisciLibro/{idprestito}", method = RequestMethod.PUT)
	public PrestitoDto restituisciLibro(@Valid @RequestBody PrestitoDto p, @PathVariable("idprestito") long id) {

		p.setId(id);
		ps.restituisciLibro(p);

		return ps.getPrestitoById(id);
	}
}
