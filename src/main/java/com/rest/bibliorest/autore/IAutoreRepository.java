package com.rest.bibliorest.autore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutoreRepository extends JpaRepository<Autore, Long>{
	
	@Query(value = "SELECT a.* FROM autori a JOIN libri l ON l.autore_id = a.id JOIN libro_editore le ON le.libro_id = l.libro_id WHERE le.editore_id = :id", nativeQuery = true)
	List<Autore> getListaAutoriByEditore(@Param("id") long id);

}
