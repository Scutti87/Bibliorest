package com.rest.bibliorest.libro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
	
	@Query(value = "SELECT * FROM libri l WHERE l.autore_id = :id", nativeQuery = true)
	List<Libro> getListaLibriByAutore(@Param("id") long id);
	
	@Query(value = "SELECT l.*, le.editore_id FROM libri l JOIN libro_editore le ON l.libro_id = le.libro_id WHERE le.editore_id = :id;", nativeQuery = true)
	List<Libro> getListaLibriByEditore(@Param("id") long id);
	
	@Query(value = "SELECT * FROM libri l WHERE l.disponibile = 1", nativeQuery = true)
	List<Libro> getListaLibriDisponibili();
}
