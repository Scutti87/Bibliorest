package com.rest.bibliorest.prestito;

import java.io.Serializable;
import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rest.bibliorest.libro.LibroDto;
import com.rest.bibliorest.operatore.OperatoreDto;
import com.rest.bibliorest.utente.UtenteDto;
import jakarta.validation.constraints.NotNull;

public class PrestitoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	@NotNull(message = "Campo data prestito obbligatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataPrestito;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataRestituzione;
	private UtenteDto utente;
	private OperatoreDto operatore;
	private LibroDto libroInPrestito;

	public PrestitoDto() {
	}

	public PrestitoDto(Date dataPrestito, UtenteDto utente, OperatoreDto operatore, LibroDto libroInPrestito) {
		this.dataPrestito = dataPrestito;
		this.utente = utente;
		this.operatore = operatore;
		this.libroInPrestito = libroInPrestito;
	}

	public PrestitoDto(long id, Date dataPrestito, UtenteDto utente, OperatoreDto operatore, LibroDto libroInPrestito) {
		this.id = id;
		this.dataPrestito = dataPrestito;
		this.utente = utente;
		this.operatore = operatore;
		this.libroInPrestito = libroInPrestito;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataPrestito() {
		return dataPrestito;
	}

	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	public UtenteDto getUtente() {
		return utente;
	}

	public void setUtente(UtenteDto utente) {
		this.utente = utente;
	}

	public OperatoreDto getOperatore() {
		return operatore;
	}

	public void setOperatore(OperatoreDto operatore) {
		this.operatore = operatore;
	}

	public LibroDto getLibroInPrestito() {
		return libroInPrestito;
	}

	public void setLibroInPrestito(LibroDto libroInPrestito) {
		this.libroInPrestito = libroInPrestito;
	}

	public Date getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

}
