package com.votaciones.registraduria.service;

import com.votaciones.registraduria.dto.CandidatoDto;
import com.votaciones.registraduria.dto.CandidatoListDto;
import com.votaciones.registraduria.dto.VotosDto;
import com.votaciones.registraduria.dto.VotosListDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VotoService {
    ResponseEntity<String> registraVoto(VotosDto votosDto);
    ResponseEntity<List<VotosListDto>> getAllVotos();
}
