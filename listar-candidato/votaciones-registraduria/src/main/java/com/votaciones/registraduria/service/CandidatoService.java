package com.votaciones.registraduria.service;

import com.votaciones.registraduria.dto.CandidatoDto;
import org.example.dto.CandidatoListDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CandidatoService {
    ResponseEntity<List<CandidatoListDto>> getAllCandidato();

}
