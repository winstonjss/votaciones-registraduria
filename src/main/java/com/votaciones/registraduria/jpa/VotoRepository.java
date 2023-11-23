package com.votaciones.registraduria.jpa;

import com.votaciones.registraduria.model.Voto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Integer> {

}
