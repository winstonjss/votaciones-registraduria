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

    @GetMapping
    @RequestMapping(value = "consutar-candidatos")
    public ResponseEntity<List<CandidatoListDto>> getAllCandidato(){
        ResponseEntity<List<CandidatoListDto>> response = serviceRegistraduria.getAllCandidato();
        return response;
    }

}
