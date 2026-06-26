package com.luca.engineer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luca.engineer.models.Ruolo;

@Repository
public interface RuoloRepository extends CrudRepository<Ruolo, String> {

}
