package com.votaciones.registraduria.jpa;


import com.votaciones.registraduria.model.Partido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartidoRepository extends CrudRepository<Partido, Integer> {

    Optional<Partido> findByNumero(Integer numero);
}