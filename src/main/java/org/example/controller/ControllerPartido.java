package org.example.controller;

import org.example.dto.PartidoDto;
import org.example.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerPartido {

    @Autowired
    private PartidoService partidoService;

    @PostMapping
    @RequestMapping(value = "crear-partido")
    public ResponseEntity<String> createMesa(@RequestBody PartidoDto partidoDto){
        ResponseEntity<String> response = partidoService.createPartido(partidoDto);
        return response;
    }
    @GetMapping
    @RequestMapping(value = "consutar-partidos")
    public ResponseEntity<List<PartidoDto>> getAllMesa(){
        ResponseEntity<List<PartidoDto>> response = partidoService.getAllPartido();
        return response;
    }

    @PutMapping
    @RequestMapping(value = "editar-partido")
    public ResponseEntity<String> updateMesa(@RequestBody PartidoDto partidoDto){
        ResponseEntity<String> response = partidoService.updatePartido(partidoDto);
        return response;
    }
    @DeleteMapping
    @RequestMapping(value = "eliminar-partido")
    public ResponseEntity<String> deleteCandidato(@RequestBody  PartidoDto partidoDto){
        ResponseEntity<String> response = partidoService.deletePartido(partidoDto);
        return response;
    }
}
