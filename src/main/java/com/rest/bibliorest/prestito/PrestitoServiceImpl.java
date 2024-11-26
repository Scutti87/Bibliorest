package com.rest.bibliorest.prestito;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.bibliorest.exception.DataConflicException;
import com.rest.bibliorest.libro.ILibroRepository;
import com.rest.bibliorest.libro.Libro;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PrestitoServiceImpl implements IPrestitoService {

	private ModelMapper mm;
	private IPrestitoRepository pr;
	private ILibroRepository lr;

	@Autowired
	public PrestitoServiceImpl(ModelMapper mm, IPrestitoRepository pr, ILibroRepository lr) {
		this.mm = mm;
		this.pr = pr;
		this.lr = lr;
	}

	@Override
	public PrestitoDto getPrestitoById(long id) {

		Prestito a = pr.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Prestito con id %d non presente in db", id)));

		return mm.map(a, PrestitoDto.class);
	}

	@Override
	public List<PrestitoDto> getListaPrestiti() {

		List<PrestitoDto> listaDto = new ArrayList<PrestitoDto>();
		List<Prestito> lista = pr.findAll();
		if (lista.isEmpty()) {
			throw new EntityNotFoundException("Nessun Prestito presente in db");
		}

		lista.forEach(a -> listaDto.add(mm.map(a, PrestitoDto.class)));

		return listaDto;
	}

	@Override
	public PrestitoDto prestaLibro(PrestitoDto p) {

		List<Prestito> lista = pr.findAll();
		Libro l = lr.findById(p.getLibroInPrestito().getId()).orElseThrow(() -> new EntityNotFoundException("Libro non presente in db"));
		if (!l.isDisponibile()) {
			throw new EntityNotFoundException("Libro non disponibile");
		}
		
		if (lista.stream().anyMatch(pr -> pr.getDataPrestito().equals(p.getDataPrestito())
				&& pr.getLibroInPrestito().getId() == p.getLibroInPrestito().getId())) {
			throw new DataConflicException("Prestito già presente in db");
		}
		
		long id = pr.recuperaUltimoId() + 1;
		pr.setAutoincrement(id);
		p.setId(id);
		l.setDisponibile(false);
		
		pr.save(mm.map(p, Prestito.class));
		
		
		return mm.map(pr.findById(id).get(), PrestitoDto.class);		
	}

	@Override
	public boolean restituisciLibro(PrestitoDto p) {

		pr.findById(p.getId()).orElseThrow(() -> new EntityNotFoundException("Prestito non presente in db"));
		Libro l = lr.findById(p.getLibroInPrestito().getId()).get();
		
		if (l.isDisponibile()) {
			throw new DataConflicException("Libro già restituito");
		}
		
		l.setDisponibile(true);
		pr.save(mm.map(p, Prestito.class));
		
		return true;
	}
}
