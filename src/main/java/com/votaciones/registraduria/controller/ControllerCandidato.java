package com.votaciones.registraduria.controller;



import com.votaciones.registraduria.dto.CandidatoDto;
import com.votaciones.registraduria.dto.CandidatoListDto;
import com.votaciones.registraduria.service.CandidatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping
    @RequestMapping(value = "editar-candidato")
    public ResponseEntity<String> updateCandidato(@RequestBody  CandidatoDto candidatoDto){
        ResponseEntity<String> response = serviceRegistraduria.updateCandidato(candidatoDto);
        return response;
    }
    @GetMapping
    @RequestMapping(value = "eliminar-candidato")
    public ResponseEntity<String> deleteCandidato(@RequestParam("cedula") String cedula){
        ResponseEntity<String> response = serviceRegistraduria.deleteCandidato(cedula);
        return response;
    }
}