package com.votaciones.registraduria.jpa;


import com.votaciones.registraduria.model.Mesa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MesaRepository extends CrudRepository<Mesa, Integer> {
    Optional<Mesa> findByNumero(Integer numero);
}