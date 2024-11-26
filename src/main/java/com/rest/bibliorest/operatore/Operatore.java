package com.rest.bibliorest.operatore;

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
@Table(name = "operatori")
public class Operatore extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String codfisc;
	private Date dataAssunzione;
	private int livello;
	@OneToOne
	private Contatti contatti;
	@OneToMany(mappedBy = "operatore")
	private List<Prestito> prestitiGestiti;

	public Operatore() {
	}

	public Operatore(String nome, String cognome, Date ddn, String codfisc, Contatti contatti, Date dataAssunzione,
			int livello, List<Prestito> prestitiGestiti) {
		super(nome, cognome, ddn);
		this.codfisc = codfisc;
		this.dataAssunzione = dataAssunzione;
		this.livello = livello;
		this.prestitiGestiti = prestitiGestiti;
	}

	public Operatore(String nome, String cognome, Date ddn, String codfisc, Contatti contatti, long id,
			Date dataAssunzione, int livello, List<Prestito> prestitiGestiti) {
		super(nome, cognome, ddn);
		this.id = id;
		this.codfisc = codfisc;
		this.dataAssunzione = dataAssunzione;
		this.livello = livello;
		this.prestitiGestiti = prestitiGestiti;
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
	
	public Contatti getContatti() {
		return contatti;
	}

	public void setContatti(Contatti contatti) {
		this.contatti = contatti;
	}

	public List<Prestito> getPrestitiGestiti() {
		return prestitiGestiti;
	}

	public void setPrestitiGestiti(List<Prestito> prestito) {
		this.prestitiGestiti = prestito;
	}

	public String getCodfisc() {
		return codfisc;
	}

	public void setCodfisc(String codfisc) {
		this.codfisc = codfisc;
	}

}
