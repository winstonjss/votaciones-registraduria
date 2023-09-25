package org.example.controller;

import org.example.dto.MesaDto;
import org.example.service.ActualizarMesaService;
import org.example.service.CrearMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ControllerMesaActualizar {
    @Autowired
    private ActualizarMesaService mesaService;

    @PutMapping
    @RequestMapping(value = "editar-mesa")
    public ResponseEntity<String> updateMesa(@RequestBody MesaDto mesaDto){
        ResponseEntity<String> response = mesaService.updateMesa(mesaDto);
        return response;
    }
}
