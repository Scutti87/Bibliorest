package com.rest.bibliorest.libro;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rest.bibliorest.autore.AutoreDto;
import com.rest.bibliorest.enums.GenereLibro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LibroDto {

	private long id;
	@NotBlank(message = "Campo titolo obbligatorio")
	private String titolo;
	private AutoreDto autore;
	@NotNull(message = "Campo data pubblicazione obbligatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataPubblicazione;
	@NotBlank(message = "Campo genere obbligatorio")
	private GenereLibro genere;
	@NotNull(message = "Campo numero pagine obbligatorio")
	private int pagine;
	@NotBlank(message = "Campo descrizione obbligatorio")
	private String descrizione;
	private boolean disponibile;
	private long idEditore;
	
	public LibroDto() {
	}

	public LibroDto(String titolo, AutoreDto autore, Date dataPubblicazione,
			GenereLibro genere, int pagine, String descrizione, boolean disponibile) {
		this.titolo = titolo;
		this.autore = autore;
		this.dataPubblicazione = dataPubblicazione;
		this.genere = genere;
		this.pagine = pagine;
		this.descrizione = descrizione;
		this.disponibile = disponibile;
	}

	public LibroDto(long id, String titolo, AutoreDto autore, Date dataPubblicazione,
			GenereLibro genere, int pagine, String descrizione, boolean disponibile) {
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.dataPubblicazione = dataPubblicazione;
		this.genere = genere;
		this.pagine = pagine;
		this.descrizione = descrizione;
		this.disponibile = disponibile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public AutoreDto getAutore() {
		return autore;
	}

	public void setAutore(AutoreDto autore) {
		this.autore = autore;
	}

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public GenereLibro getGenere() {
		return genere;
	}

	public void setGenere(GenereLibro genere) {
		this.genere = genere;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public long getIdEditore() {
		return idEditore;
	}

	public void setIdEditore(long idEditore) {
		this.idEditore = idEditore;
	}

	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}

}
