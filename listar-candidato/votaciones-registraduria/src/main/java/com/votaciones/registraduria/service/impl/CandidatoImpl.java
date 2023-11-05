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

}
