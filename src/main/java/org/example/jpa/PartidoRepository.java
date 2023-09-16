package org.example.jpa;

import org.example.model.Candidato;
import org.example.model.Partido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartidoRepository extends CrudRepository<Partido, Integer> {

    Optional<Partido> findByNumero(Integer numero);
}
