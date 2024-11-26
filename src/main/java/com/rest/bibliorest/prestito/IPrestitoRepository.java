package com.rest.bibliorest.prestito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

@Repository
public interface IPrestitoRepository extends JpaRepository<Prestito, Long> {
	
	@Query(value = "SELECT p.id FROM prestiti p ORDER BY p.id DESC LIMIT 1", nativeQuery = true)
	long recuperaUltimoId();
	
	@Transactional
	@Modifying
	@Query(value = "ALTER TABLE prestiti AUTO_INCREMENT = :id", nativeQuery = true)
	void setAutoincrement(@Param("id") long id);

}
