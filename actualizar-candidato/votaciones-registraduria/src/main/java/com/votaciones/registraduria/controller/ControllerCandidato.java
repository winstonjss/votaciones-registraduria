package com.votaciones.registraduria.controller;


import com.votaciones.registraduria.dto.CandidatoDto;
import com.votaciones.registraduria.service.CandidatoService;
import org.example.dto.CandidatoListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class ControllerCandidato {

    @Autowired
    private CandidatoService serviceRegistraduria;

    @PutMapping
    @RequestMapping(value = "editar-candidato")
    public ResponseEntity<String> updateCandidato(@RequestBody  CandidatoDto candidatoDto){
        ResponseEntity<String> response = serviceRegistraduria.updateCandidato(candidatoDto);
        return response;
    }

}
