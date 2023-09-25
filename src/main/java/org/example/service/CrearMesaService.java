package org.example.service;

import org.example.dto.MesaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrearMesaService {
    ResponseEntity<String> createMesa(MesaDto mesaDto);
}
