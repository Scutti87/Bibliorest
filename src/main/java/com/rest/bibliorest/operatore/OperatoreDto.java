package com.rest.bibliorest.operatore;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rest.bibliorest.contatti.ContattiDto;
import com.rest.bibliorest.persona.PersonaDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OperatoreDto extends PersonaDto {

	private long id;
	@NotBlank(message = "Campo codice fiscale obbligatorio")
	private String codfisc;
	@NotNull(message = "Campo data assunzione obbligatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataAssunzione;
	private int livello;
	private ContattiDto contatti;

	public OperatoreDto() {
	}

	public OperatoreDto(String nome, String cognome, Date ddn, String codfisc, ContattiDto contatti,
			Date dataAssunzione, int livello) {
		super(nome, cognome, ddn);
		this.codfisc = codfisc;
		this.dataAssunzione = dataAssunzione;
		this.livello = livello;
	}

	public OperatoreDto(String nome, String cognome, Date ddn, String codfisc, ContattiDto contatti, long id,
			Date dataAssunzione, int livello) {
		super(nome, cognome, ddn);
		this.id = id;
		this.codfisc = codfisc;
		this.dataAssunzione = dataAssunzione;
		this.livello = livello;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public int getLivello() {
		return livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

	public ContattiDto getContatti() {
		return contatti;
	}

	public void setContatti(ContattiDto contatti) {
		this.contatti = contatti;
	}

	public String getCodfisc() {
		return codfisc;
	}

	public void setCodfisc(String codfisc) {
		this.codfisc = codfisc;
	}

}
