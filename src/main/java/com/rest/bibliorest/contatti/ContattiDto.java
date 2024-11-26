package com.rest.bibliorest.contatti;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ContattiDto {

	private long id;
	@NotBlank(message = "Campo indirizzo obbligatorio")
	private String indirizzo;
	@NotBlank(message = "Campo cap obbligatorio")
	private String cap;
	@NotBlank(message = "Campo citta obbligatorio")
	private String citta;
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Inserire una email valida")
	private String email;
	@NotBlank(message = "Campo telefono obbligatorio")
	private String telefono;

	public ContattiDto() {
	}

	public ContattiDto(String indirizzo, String cap, String citta, String email, String telefono) {
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.citta = citta;
		this.email = email;
		this.telefono = telefono;
	}

	public ContattiDto(long id, String indirizzo, String cap, String citta, String email, String telefono) {
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
