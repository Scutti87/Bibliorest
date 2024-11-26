package com.rest.bibliorest.contatti;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contatti")
public class Contatti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String indirizzo;
	private String cap;
	private String citta;
	private String email;
	private String telefono;

	public Contatti() {
	}

	public Contatti(String indirizzo, String cap, String citta, String email, String telefono) {
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.citta = citta;
		this.email = email;
		this.telefono = telefono;
	}

	public Contatti(long id, String indirizzo, String cap, String citta, String email, String telefono) {
		this.id = id;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.citta = citta;
		this.email = email;
		this.telefono = telefono;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
