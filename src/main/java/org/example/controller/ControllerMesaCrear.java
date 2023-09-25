package org.example.controller;

import org.example.dto.MesaDto;
import org.example.service.CrearMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ControllerMesaCrear {

    @Autowired
    private CrearMesaService mesaService;
    @PostMapping
    @RequestMapping(value = "crear-mesa")
    public ResponseEntity<String> createMesa(@RequestBody MesaDto mesaDto){
        ResponseEntity<String> response = mesaService.createMesa(mesaDto);
        return response;
    }
}
