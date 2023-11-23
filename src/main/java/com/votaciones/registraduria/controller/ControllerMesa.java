package com.votaciones.registraduria.controller;




import com.votaciones.registraduria.dto.MesaDto;
import com.votaciones.registraduria.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @PostMapping
    @RequestMapping(value = "editar-mesa")
    public ResponseEntity<String> updateMesa(@RequestBody MesaDto mesaDto){
        ResponseEntity<String> response = mesaService.updateMesa(mesaDto);
        return response;
    }
    @GetMapping
    @RequestMapping(value = "eliminar-mesa")
    public ResponseEntity<String> deleteCandidato(@RequestParam("numeroMesa") String mesaDto){
        ResponseEntity<String> response = mesaService.deleteMesa(mesaDto);
        return response;
    }
}