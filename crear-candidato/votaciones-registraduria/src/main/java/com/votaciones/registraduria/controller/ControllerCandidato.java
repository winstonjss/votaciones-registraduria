package com.votaciones.registraduria.controller;


import com.votaciones.registraduria.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.votaciones.registraduria.dto.*;
import java.util.List;


@RestController
@CrossOrigin
public class ControllerCandidato {

    @Autowired
    private CandidatoService serviceRegistraduria;

    @PostMapping
    @RequestMapping(value = "crear-candidato")
    public ResponseEntity<String> registrarCandidato(@RequestBody CandidatoDto candidatoDto){
        ResponseEntity<String> response = serviceRegistraduria.crearCandidato(candidatoDto);
        return response;
    }

}
