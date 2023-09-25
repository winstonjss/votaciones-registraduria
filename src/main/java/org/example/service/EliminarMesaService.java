package org.example.service;

import org.example.dto.CandidatoDto;
import org.example.dto.CandidatoListDto;
import org.example.dto.MesaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EliminarMesaService {

    ResponseEntity<String> deleteMesa(MesaDto mesaDto);
}
