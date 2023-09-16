package org.example.service;

import org.example.dto.MesaDto;
import org.example.dto.PartidoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PartidoService {
    ResponseEntity<String> createPartido(PartidoDto partidoDto);
    ResponseEntity<List<PartidoDto>> getAllPartido();
    ResponseEntity<String> updatePartido(PartidoDto partidoDto);
    ResponseEntity<String> deletePartido(PartidoDto partidoDto);
}
