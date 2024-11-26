package com.rest.bibliorest.libro;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.rest.bibliorest.autore.Autore;
import com.rest.bibliorest.config.GenereLibroConverter;
import com.rest.bibliorest.editore.Editore;
import com.rest.bibliorest.enums.GenereLibro;
import com.rest.bibliorest.prestito.Prestito;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "libri")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "libro_id")
	private long id;
	private String titolo;
	private Date dataPubblicazione;
	@Convert(converter = GenereLibroConverter.class)
	private GenereLibro genere;
	private int pagine;
	private String descrizione;
	private boolean disponibile;
	@OneToMany(mappedBy = "libroInPrestito")
	private List<Prestito> prestiti;
	@ManyToOne
	private Autore autore;
	@ManyToMany
	@JoinTable(name = "libro_editore", joinColumns = @JoinColumn(name = "libro_id"), inverseJoinColumns = @JoinColumn(name = "editore_id"))
	private List<Editore> editori;

	public Libro() {
	}

	public Libro(String titolo, Autore autore, List<Prestito> prestiti, List<Editore> editori, Date dataPubblicazione, GenereLibro genere,
			int pagine, String descrizione, boolean disponibile) {
		this.titolo = titolo;
		this.autore = autore;
		this.editori = editori;
		this.dataPubblicazione = dataPubblicazione;
		this.genere = genere;
		this.pagine = pagine;
		this.descrizione = descrizione;
		this.disponibile = disponibile;
		this.prestiti = prestiti;
	}

	public Libro(long id, String titolo, Autore autore, List<Prestito> prestiti, List<Editore> editori, Date dataPubblicazione,
			GenereLibro genere, int pagine, String descrizione, boolean disponibile) {
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.editori = editori;
		this.dataPubblicazione = dataPubblicazione;
		this.genere = genere;
		this.pagine = pagine;
		this.descrizione = descrizione;
		this.disponibile = disponibile;
		this.prestiti = prestiti;
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

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public List<Editore> getEditori() {
		return editori;
	}

	public void setEditori(List<Editore> editori) {
		this.editori = editori;
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

	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}

	public List<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(List<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

}
