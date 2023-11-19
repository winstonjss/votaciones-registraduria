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
    public ResponseEntity<String> crearCandidato(CandidatoDto candidatoDto) {

        try {

            Optional<Candidato> candidatoVerificar =
                    candidatoRepository.findByCedula(candidatoDto.getCedula());
            if (!candidatoVerificar.isPresent()) {
                Partido partido = new Partido();
                partido.setId(candidatoDto.getIdPartido());
                Candidato candidato = new Candidato();
                candidato.setPartido(partido);
                candidato.setNombre(candidatoDto.getNombre());
                candidato.setApellido(candidatoDto.getApellido());
                candidato.setCedula(candidatoDto.getCedula());
                candidatoRepository.save(candidato);
                return ResponseEntity.ok("Se ha creado el candidato");
            }else {
                return ResponseEntity.badRequest().body("El numero de cedula ya existe");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al crear el candidato");
        }

    }

    @Override
    public ResponseEntity<List<CandidatoListDto>> getAllCandidato() {
        List<Candidato> list = (List<Candidato>) candidatoRepository.findAll();

        List<CandidatoListDto> listDtos = new ArrayList<>();

        for(Candidato candidato : list){
            CandidatoListDto candidatoListDto = new CandidatoListDto();
            candidatoListDto.setApellido(candidato.getApellido());
            candidatoListDto.setCedula(candidato.getCedula());
            candidatoListDto.setNombre(candidato.getNombre());
            candidatoListDto.setNombrePartido(candidato.getPartido().getNombre());
            listDtos.add(candidatoListDto);
        }

        return ResponseEntity.ok(listDtos);
    }

    @Override
    public ResponseEntity<String> updateCandidato(CandidatoDto candidatoDto) {
        try {
            Optional<Candidato> candidatoVerificar =
                    candidatoRepository.findByCedula(candidatoDto.getCedula());
            if (candidatoVerificar.isPresent()) {
                Partido partido = new Partido();
                partido.setId(candidatoDto.getIdPartido());
                Candidato candidato = new Candidato();
                candidato.setId(candidatoVerificar.get().getId());
                candidato.setPartido(partido);
                candidato.setNombre(candidatoDto.getNombre());
                candidato.setApellido(candidatoDto.getApellido());
                candidato.setCedula(candidatoDto.getCedula());
                candidatoRepository.save(candidato);
                return ResponseEntity.ok("Se ha editado el candidato");
            }else {
                return ResponseEntity.badRequest().body("El numero de cedula no existe para editar");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al editar el candidato");
        }
    }

    @Override
    public ResponseEntity<String> deleteCandidato(CandidatoDto candidatoDto) {
        try {
            Optional<Candidato> candidatoVerificar =
                    candidatoRepository.findByCedula(candidatoDto.getCedula());
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