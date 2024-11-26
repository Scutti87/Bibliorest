package com.rest.bibliorest.editore;

import java.io.Serializable;
import java.util.List;
import com.rest.bibliorest.contatti.Contatti;
import com.rest.bibliorest.libro.Libro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "editori")
public class Editore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "editore_id")
	private long id;
	private String nome;
	@OneToOne
	private Contatti contatti;
	@ManyToMany
	@JoinTable(name = "libro_editore", joinColumns = @JoinColumn(name = "editore_id"), inverseJoinColumns = @JoinColumn(name = "libro_id"))
	private List<Libro> libriPubblicati;

	public Editore(long id, String nome, Contatti contatti) {
		this.id = id;
		this.nome = nome;
		this.contatti = contatti;
	}

	public Editore(String nome, Contatti contatti) {
		this.nome = nome;
		this.contatti = contatti;
	}

	public Editore() {
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

	public List<Libro> getLibriPubblicati() {
		return libriPubblicati;
	}

	public void setLibriPubblicati(List<Libro> libriPubblicati) {
		this.libriPubblicati = libriPubblicati;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
