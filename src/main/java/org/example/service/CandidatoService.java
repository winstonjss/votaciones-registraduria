package org.example.service;

import org.example.dto.CandidatoDto;
import org.example.dto.CandidatoListDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CandidatoService {
    ResponseEntity<String> crearCandidato(CandidatoDto candidatoDto);
    ResponseEntity<List<CandidatoListDto>> getAllCandidato();

    ResponseEntity<String> updateCandidato(CandidatoDto candidatoDto);

    ResponseEntity<String> deleteCandidato(CandidatoDto candidatoDto);

}
