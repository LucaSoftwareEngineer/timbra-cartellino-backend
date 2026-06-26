package com.luca.engineer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luca.engineer.models.Dipendente;

@Repository
public interface DipendenteRepository extends CrudRepository<Dipendente, String> {

}
