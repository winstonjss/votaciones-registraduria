package com.votaciones.registraduria.service;


import org.springframework.http.ResponseEntity;
import com.votaciones.registraduria.dto.*;
import java.util.List;

public interface CandidatoService {
    ResponseEntity<String> crearCandidato(CandidatoDto candidatoDto);

}
