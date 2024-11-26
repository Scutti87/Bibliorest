package com.rest.bibliorest.editore;

import com.rest.bibliorest.contatti.ContattiDto;

import jakarta.validation.constraints.NotBlank;

public class EditoreDto {

	private long id;
	@NotBlank(message = "Campo nome obbligatorio")
	private String nome;
	private ContattiDto contatti;

	public EditoreDto(long id, String nome, ContattiDto contatti) {
		this.id = id;
		this.nome = nome;
		this.contatti = contatti;
	}

	public EditoreDto(String nome, ContattiDto contatti) {
		this.nome = nome;
		this.contatti = contatti;
	}

	public EditoreDto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ContattiDto getContatti() {
		return contatti;
	}

	public void setContatti(ContattiDto contatti) {
		this.contatti = contatti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
