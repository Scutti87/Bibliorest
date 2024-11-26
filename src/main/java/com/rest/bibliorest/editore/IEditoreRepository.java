package com.rest.bibliorest.editore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEditoreRepository extends JpaRepository<Editore, Long>{

}
