package com.rest.bibliorest.utente;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rest.bibliorest.contatti.ContattiDto;
import com.rest.bibliorest.persona.PersonaDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UtenteDto extends PersonaDto {

	private long id;
	@NotBlank(message = "Campo codice fiscale obbligatorio")
	private String codfisc;
	private ContattiDto contatti;
	@NotNull(message = "Campo data registrazione obbligatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataRegistrazione;

	public UtenteDto() {
	}

	public UtenteDto(String nome, String cognome, Date ddn, String codfisc, ContattiDto contatti,
			Date dataRegistrazione) {
		super(nome, cognome, ddn);
		this.codfisc = codfisc;
		this.dataRegistrazione = dataRegistrazione;
	}

	public UtenteDto(String nome, String cognome, Date ddn, String codfisc, ContattiDto contatti, long id,
			Date dataRegistrazione) {
		super(nome, cognome, ddn);
		this.id = id;
		this.codfisc = codfisc;
		this.dataRegistrazione = dataRegistrazione;
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

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public String getCodfisc() {
		return codfisc;
	}

	public void setCodfisc(String codfisc) {
		this.codfisc = codfisc;
	}

}
