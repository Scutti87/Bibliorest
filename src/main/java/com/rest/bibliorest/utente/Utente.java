package com.rest.bibliorest.utente;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import com.rest.bibliorest.contatti.Contatti;
import com.rest.bibliorest.persona.Persona;
import com.rest.bibliorest.prestito.Prestito;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String codfisc;
	private Date dataRegistrazione;
	@OneToMany(mappedBy = "utente")
	private List<Prestito> prestitiEffettuati;
	@OneToOne
	private Contatti contatti;

	public Utente() {
	}

	public Utente(String nome, String cognome, Date ddn, String codfisc, Contatti contatti, List<Prestito> prestiti,
			Date dataRegistrazione) {
		super(nome, cognome, ddn);
		this.codfisc = codfisc;
		this.prestitiEffettuati = prestiti;
		this.dataRegistrazione = dataRegistrazione;
	}

	public Utente(String nome, String cognome, Date ddn, String codfisc, Contatti contatti, long id,
			List<Prestito> prestiti, Date dataRegistrazione) {
		super(nome, cognome, ddn);
		this.id = id;
		this.codfisc = codfisc;
		this.prestitiEffettuati = prestiti;
		this.dataRegistrazione = dataRegistrazione;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Contatti getContatti() {
		return contatti;
	}

	public void setContatti(Contatti contatti) {
		this.contatti = contatti;
	}

	public List<Prestito> getPrestitiEffettuati() {
		return prestitiEffettuati;
	}

	public void setPrestitiEffettuati(List<Prestito> prestiti) {
		this.prestitiEffettuati = prestiti;
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
