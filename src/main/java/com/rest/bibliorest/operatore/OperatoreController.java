package com.rest.bibliorest.operatore;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/operatore")
public class OperatoreController {

	private IOperatoreService os;

	public OperatoreController(IOperatoreService os) {
		this.os = os;
	}
	
	@RequestMapping("cerca/{id}")
	public OperatoreDto getOperatoreById(@PathVariable("id") long id) {
		
		OperatoreDto a = os.getOperatoreById(id);
		
		return a;
	}
	
	@RequestMapping("lista")
	public Iterable<OperatoreDto> getListaOperatori() {
		
		List<OperatoreDto> lista = os.getListaOperatori();
		
		return lista;
	}
}
