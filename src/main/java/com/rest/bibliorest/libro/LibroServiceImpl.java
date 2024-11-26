package com.rest.bibliorest.libro;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.bibliorest.autore.Autore;

import com.rest.bibliorest.editore.Editore;
import com.rest.bibliorest.editore.IEditoreRepository;
import com.rest.bibliorest.exception.DataConflicException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LibroServiceImpl implements ILibroService {

	private ModelMapper mm;
	private ILibroRepository lr;
	private IEditoreRepository er;

	@Autowired
	public LibroServiceImpl(ModelMapper mm, ILibroRepository lr, IEditoreRepository er) {
		this.mm = mm;
		this.lr = lr;
		this.er = er;
	}

	private Libro mapperToEntity(LibroDto ld) {

		Editore e = er.findById(ld.getIdEditore()).orElseThrow(() -> new EntityNotFoundException(
				String.format("Editore con id %d non presente in db", ld.getIdEditore())));

		Libro l = new Libro();
		l.setAutore(mm.map(ld.getAutore(), Autore.class));
		l.setDataPubblicazione(ld.getDataPubblicazione());
		l.setDescrizione(ld.getDescrizione());
		l.setDisponibile(ld.isDisponibile());
		l.setGenere(ld.getGenere());
		l.setPagine(ld.getPagine());
		l.setTitolo(ld.getTitolo());
		l.setId(ld.getId());

		if (lr.findById(ld.getId()).isEmpty()) {
			l.setEditori(List.of(e));
		} else {
			List<Editore> lista = lr.findById(ld.getId()).get().getEditori();
			lista.add(e);
			l.setEditori(lista);
		}

		return l;
	}

//	private LibroDto mapperToDto(Libro l) {
//
//		LibroDto ld = new LibroDto();
//		ld.setAutore(mm.map(l.getAutore(), AutoreDto.class));
//		ld.setDataPubblicazione(l.getDataPubblicazione());
//		ld.setDescrizione(l.getDescrizione());
//		ld.setDisponibile(l.isDisponibile());
//		ld.setGenere(l.getGenere());
//		ld.setPagine(l.getPagine());
//		ld.setTitolo(l.getTitolo());
//		ld.setId(l.getId());
//
//		return ld;
//	}

	@Override
	public LibroDto getLibroById(long id) {

		Libro a = lr.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Libro con id %d non presente in db", id)));

		return mm.map(a, LibroDto.class);
	}

	@Override
	public List<LibroDto> getListaLibri() {

		List<LibroDto> listaDto = new ArrayList<LibroDto>();
		List<Libro> lista = lr.findAll();
		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun Libro presente in db");
		}

		lista.forEach(a -> listaDto.add(mm.map(a, LibroDto.class)));

		return listaDto;
	}

	@Override
	public boolean aggiorna(LibroDto l) {

		lr.findById(l.getId()).orElseThrow(
				() -> new EntityNotFoundException(String.format("Libro con id %d non presente in db", l.getId())));
		List<Libro> lista = lr.findAll();
		lista.remove(lr.findById(l.getId()).get());

		if (lista.stream()
				.anyMatch(lib -> lib.getTitolo().equalsIgnoreCase(l.getTitolo())
						&& lib.getAutore().getId() == l.getAutore().getId()
						&& lib.getEditori().stream().anyMatch(e -> e.getId() == l.getIdEditore()))) {
			throw new DataConflicException("Il libro risulta già presente in db");
		}

		lr.save(mapperToEntity(l));
		return true;
	}

	@Override
	public List<LibroDto> getListaLibriByAutore(long id) {
		
		List<LibroDto> listaDto = new ArrayList<LibroDto>();
		List<Libro> lista = lr.getListaLibriByAutore(id);
		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun Libro presente in db con id autore " + id);
		}

		lista.forEach(a -> listaDto.add(mm.map(a, LibroDto.class)));

		return listaDto;
	}

	@Override
	public List<LibroDto> getListaLibriByEditore(long id) {

		List<LibroDto> listaDto = new ArrayList<LibroDto>();
		List<Libro> lista = lr.getListaLibriByEditore(id);
		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun Libro presente in db con id editore " + id);
		}

		lista.forEach(a -> listaDto.add(mm.map(a, LibroDto.class)));

		return listaDto;
	}

	@Override
	public List<LibroDto> getListaLibriDisponibili() {

		List<LibroDto> listaDto = new ArrayList<LibroDto>();
		List<Libro> lista = lr.getListaLibriDisponibili();
		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun Libro disponibile");
		}

		lista.forEach(a -> listaDto.add(mm.map(a, LibroDto.class)));

		return listaDto;
	}

}
