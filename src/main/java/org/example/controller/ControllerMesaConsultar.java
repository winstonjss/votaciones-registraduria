package org.example.controller;

import org.example.dto.MesaDto;
import org.example.service.ConsultarMesasService;
import org.example.service.CrearMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin
public class ControllerMesaConsultar {
    @Autowired
    private ConsultarMesasService mesaService;
    @GetMapping
    @RequestMapping(value = "consutar-mesa")
    public ResponseEntity<List<MesaDto>> getAllMesa(){
        ResponseEntity<List<MesaDto>> response = mesaService.getAllMesa();
        return response;
    }
}
