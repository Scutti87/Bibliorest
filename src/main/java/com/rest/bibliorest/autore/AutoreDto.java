package com.rest.bibliorest.autore;

import java.sql.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rest.bibliorest.libro.Libro;
import com.rest.bibliorest.persona.PersonaDto;
import jakarta.validation.constraints.NotNull;

public class AutoreDto extends PersonaDto {

	private long id;
	@NotNull(message = "Campo data obbligatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	private Date ddm;

	public AutoreDto() {
	}

	public AutoreDto(String nome, String cognome, Date ddn, Date ddm, List<Libro> libriScritti) {
		super(nome, cognome, ddn);
		this.ddm = ddm;
	}

	public AutoreDto(String nome, String cognome, Date ddn, long id, Date ddm, List<Libro> libriScritti) {
		super(nome, cognome, ddn);
		this.id = id;
		this.ddm = ddm;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDdm() {
		return ddm;
	}

	public void setDdm(Date ddm) {
		this.ddm = ddm;
	}

}
