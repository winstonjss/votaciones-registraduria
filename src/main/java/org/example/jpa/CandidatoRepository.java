package org.example.jpa;

import org.example.model.Candidato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Integer> {

    Optional<Candidato> findByCedula(String cedula);

}
