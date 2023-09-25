package org.example.service.impl;

import org.example.dto.MesaDto;
import org.example.jpa.MesaRepository;
import org.example.model.Mesa;
import org.example.service.CrearMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.example.util.UtilCrearMesa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrearMesaImpl implements CrearMesaService {

    @Autowired
    private MesaRepository mesaRepository;

    UtilCrearMesa utilCrearMesa = new UtilCrearMesa();
    @Override
    public ResponseEntity<String> createMesa(MesaDto mesaDto) {
        try {
            Optional<Mesa> verificarMesa =
                    mesaRepository.findByNumero(mesaDto.getNumeroMesa());
            if (!verificarMesa.isPresent()) {
                mesaRepository.save(utilCrearMesa.crearMesa(mesaDto));
                return ResponseEntity.ok("Se ha creado la mesa");
            }else {
                return ResponseEntity.badRequest().body("El numero de mesa ya existe");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al crear la mesa");
        }
    }

}
