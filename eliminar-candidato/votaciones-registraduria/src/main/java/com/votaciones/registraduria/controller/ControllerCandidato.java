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

    @DeleteMapping
    @RequestMapping(value = "eliminar-candidato")
    public ResponseEntity<String> deleteCandidato(@RequestBody  CandidatoDto candidatoDto){
        ResponseEntity<String> response = serviceRegistraduria.deleteCandidato(candidatoDto);
        return response;
    }
}
