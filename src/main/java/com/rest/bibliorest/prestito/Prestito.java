package com.rest.bibliorest.prestito;

import java.io.Serializable;
import java.sql.Date;
import com.rest.bibliorest.libro.Libro;
import com.rest.bibliorest.operatore.Operatore;
import com.rest.bibliorest.utente.Utente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestiti")
public class Prestito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date dataPrestito;
	private Date dataRestituzione;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Operatore operatore;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Libro libroInPrestito;

	public Prestito() {
	}

	public Prestito(Date dataPrestito, Utente utente, Operatore operatore, Libro libroInPrestito) {
		this.dataPrestito = dataPrestito;
		this.utente = utente;
		this.operatore = operatore;
		this.libroInPrestito = libroInPrestito;
	}

	public Prestito(long id, Date dataPrestito, Utente utente, Operatore operatore, Libro libroInPrestito) {
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Operatore getOperatore() {
		return operatore;
	}

	public void setOperatore(Operatore operatore) {
		this.operatore = operatore;
	}

	public Libro getLibroInPrestito() {
		return libroInPrestito;
	}

	public void setLibroInPrestito(Libro libroInPrestito) {
		this.libroInPrestito = libroInPrestito;
	}

	public Date getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

}
