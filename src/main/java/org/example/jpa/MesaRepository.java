package org.example.jpa;

import org.example.model.Mesa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MesaRepository extends CrudRepository<Mesa, Integer> {
    Optional<Mesa> findByNumero(Integer numero);
}
