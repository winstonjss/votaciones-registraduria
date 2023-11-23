package com.votaciones.registraduria.service;


import com.votaciones.registraduria.dto.MesaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MesaService {

    ResponseEntity<String> createMesa(MesaDto mesaDto);
    ResponseEntity<List<MesaDto>> getAllMesa();
    ResponseEntity<String> updateMesa(MesaDto mesaDto);
    ResponseEntity<String> deleteMesa(String mesaDto);
}