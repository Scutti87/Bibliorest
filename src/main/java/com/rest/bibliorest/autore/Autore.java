package com.rest.bibliorest.autore;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import com.rest.bibliorest.libro.Libro;
import com.rest.bibliorest.persona.Persona;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autori")
public class Autore extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date ddm;
	@OneToMany(mappedBy = "autore")
	private List<Libro> libriScritti;

	public Autore() {
	}

	public Autore(String nome, String cognome, Date ddn, Date ddm, List<Libro> libriScritti) {
		super(nome, cognome, ddn);
		this.ddm = ddm;
		this.libriScritti = libriScritti;
	}

	public Autore(String nome, String cognome, Date ddn, long id, Date ddm, List<Libro> libriScritti) {
		super(nome, cognome, ddn);
		this.id = id;
		this.ddm = ddm;
		this.libriScritti = libriScritti;
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

	public List<Libro> getLibriScritti() {
		return libriScritti;
	}

	public void setLibriScritti(List<Libro> libriScritti) {
		this.libriScritti = libriScritti;
	}

}
