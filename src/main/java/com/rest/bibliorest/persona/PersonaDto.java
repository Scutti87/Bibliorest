package com.rest.bibliorest.persona;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PersonaDto {
	
	@NotBlank(message = "Campo nome obbligatorio")
	private String nome;
	@NotBlank(message = "Campo cognome obbligatorio")
	private String cognome;
	@NotNull(message = "Campo data di nascita obbligatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date ddn;
	
	public PersonaDto() {
	}

	public PersonaDto(String nome, String cognome, Date ddn) {
		this.nome = nome;
		this.cognome = cognome;
		this.ddn = ddn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}


}
