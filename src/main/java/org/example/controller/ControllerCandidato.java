package org.example.controller;


import org.example.dto.CandidatoDto;
import org.example.dto.CandidatoListDto;
import org.example.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ControllerCandidato {

    @Autowired
    private CandidatoService serviceRegistraduria;

    @PostMapping
    @RequestMapping(value = "crear-candidato")
    public ResponseEntity<String> registrarCandidato(@RequestBody CandidatoDto candidatoDto){
        ResponseEntity<String> response = serviceRegistraduria.crearCandidato(candidatoDto);
        return response;
    }
    @GetMapping
    @RequestMapping(value = "consutar-candidatos")
    public ResponseEntity<List<CandidatoListDto>> getAllCandidato(){
        ResponseEntity<List<CandidatoListDto>> response = serviceRegistraduria.getAllCandidato();
        return response;
    }

    @PutMapping
    @RequestMapping(value = "editar-candidato")
    public ResponseEntity<String> updateCandidato(@RequestBody  CandidatoDto candidatoDto){
        ResponseEntity<String> response = serviceRegistraduria.updateCandidato(candidatoDto);
        return response;
    }
    @DeleteMapping
    @RequestMapping(value = "eliminar-candidato")
    public ResponseEntity<String> deleteCandidato(@RequestBody  CandidatoDto candidatoDto){
        ResponseEntity<String> response = serviceRegistraduria.deleteCandidato(candidatoDto);
        return response;
    }
}
