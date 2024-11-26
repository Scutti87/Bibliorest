package com.rest.bibliorest.persona;

import java.sql.Date;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {

	private String nome;
	private String cognome;
	private Date ddn;
	
	public Persona() {
	}

	public Persona(String nome, String cognome, Date ddn) {
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
