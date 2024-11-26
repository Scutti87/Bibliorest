package com.rest.bibliorest.editore;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/editore")
public class EditoreController {

	private IEditoreService cs;

	public EditoreController(IEditoreService cs) {
		this.cs = cs;
	}
	
	@RequestMapping("cerca/{id}")
	public EditoreDto getEditoreById(@PathVariable("id") long id) {
		
		EditoreDto a = cs.getEditoreById(id);
		
		return a;
	}
	
	@RequestMapping("lista")
	public Iterable<EditoreDto> getListaEditori() {
		
		List<EditoreDto> lista = cs.getListaEditori();
		
		return lista;
	}
}
