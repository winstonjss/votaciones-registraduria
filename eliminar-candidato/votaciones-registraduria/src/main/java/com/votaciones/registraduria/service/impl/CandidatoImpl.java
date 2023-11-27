package com.votaciones.registraduria.service.impl;

import com.votaciones.registraduria.dto.CandidatoDto;
import com.votaciones.registraduria.jpa.CandidatoRepository;
import com.votaciones.registraduria.model.Candidato;
import com.votaciones.registraduria.model.Partido;
import com.votaciones.registraduria.service.CandidatoService;
import lombok.extern.slf4j.Slf4j;

import org.example.dto.CandidatoListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CandidatoImpl implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Override
    public ResponseEntity<String> deleteCandidato(String candidatoDto) {
        try {
            Optional<Candidato> candidatoVerificar =
                    candidatoRepository.findByCedula(candidatoDto);
            if (candidatoVerificar.isPresent()) {
                candidatoRepository.delete(candidatoVerificar.get());
                return ResponseEntity.ok("Se ha eliminado el candidato");
            }else {
                return ResponseEntity.badRequest().body("El numero de cedula no existe para eliminado");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al eliminado el candidato");
        }
    }
}