package org.example.controller;

import org.example.dto.MesaDto;
import org.example.service.CrearMesaService;
import org.example.service.EliminarMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ControllerMesaEliminar {
    @Autowired
    private EliminarMesaService mesaService;

    @DeleteMapping
    @RequestMapping(value = "eliminar-mesa")
    public ResponseEntity<String> deleteCandidato(@RequestBody MesaDto mesaDto){
        ResponseEntity<String> response = mesaService.deleteMesa(mesaDto);
        return response;
    }
}
