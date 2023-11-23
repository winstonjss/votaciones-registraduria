package com.votaciones.registraduria.controller;

import com.votaciones.registraduria.dto.MesaDto;
import com.votaciones.registraduria.dto.VotosDto;
import com.votaciones.registraduria.dto.VotosListDto;
import com.votaciones.registraduria.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerVoto {

    @Autowired
    private VotoService votoService;

    @PostMapping
    @RequestMapping(value = "crear-voto")
    public ResponseEntity<String> createMesa(@RequestBody VotosDto votosDto){
        ResponseEntity<String> response = votoService.registraVoto(votosDto);
        return response;
    }
    @GetMapping
    @RequestMapping(value = "consultar-voto")
    public ResponseEntity<List<VotosListDto>> getAllMesa(){
        ResponseEntity<List<VotosListDto>> response = votoService.getAllVotos();
        return response;
    }
}
