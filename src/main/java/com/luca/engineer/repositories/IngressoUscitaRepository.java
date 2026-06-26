package com.luca.engineer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luca.engineer.models.IngressoUscita;

@Repository
public interface IngressoUscitaRepository extends CrudRepository<IngressoUscita, String> {

}
