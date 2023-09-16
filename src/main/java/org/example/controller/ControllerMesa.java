package org.example.controller;

import org.example.dto.CandidatoDto;
import org.example.dto.CandidatoListDto;
import org.example.dto.MesaDto;
import org.example.model.Mesa;
import org.example.service.CandidatoService;
import org.example.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerMesa {
    @Autowired
    private MesaService mesaService;

    @PostMapping
    @RequestMapping(value = "crear-mesa")
    public ResponseEntity<String> createMesa(@RequestBody MesaDto mesaDto){
        ResponseEntity<String> response = mesaService.createMesa(mesaDto);
        return response;
    }
    @GetMapping
    @RequestMapping(value = "consutar-mesa")
    public ResponseEntity<List<MesaDto>> getAllMesa(){
        ResponseEntity<List<MesaDto>> response = mesaService.getAllMesa();
        return response;
    }

    @PutMapping
    @RequestMapping(value = "editar-mesa")
    public ResponseEntity<String> updateMesa(@RequestBody MesaDto mesaDto){
        ResponseEntity<String> response = mesaService.updateMesa(mesaDto);
        return response;
    }
    @DeleteMapping
    @RequestMapping(value = "eliminar-mesa")
    public ResponseEntity<String> deleteCandidato(@RequestBody  MesaDto mesaDto){
        ResponseEntity<String> response = mesaService.deleteMesa(mesaDto);
        return response;
    }
}
