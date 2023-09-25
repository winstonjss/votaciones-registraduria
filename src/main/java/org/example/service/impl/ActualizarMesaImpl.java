package org.example.service.impl;

import org.example.dto.MesaDto;
import org.example.jpa.MesaRepository;
import org.example.model.Mesa;
import org.example.service.ActualizarMesaService;
import org.example.util.UtilActualizarMesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.example.util.UtilCrearMesa;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActualizarMesaImpl implements ActualizarMesaService {
    @Autowired
    private MesaRepository mesaRepository;

    UtilActualizarMesa utilActualizarMesa = new UtilActualizarMesa();

    @Override
    public ResponseEntity<String> updateMesa(MesaDto mesaDto) {
        try {
            Optional<Mesa> verificarMesa =
                    mesaRepository.findByNumero(mesaDto.getNumeroMesa());
            if (verificarMesa.isPresent()) {
                mesaRepository.save(utilActualizarMesa.actualizarMesa(mesaDto, verificarMesa.get().getId()));
                return ResponseEntity.ok("Se ha editado la mesa");
            }else {
                return ResponseEntity.badRequest().body("El numero de mesa ya existe");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al editado la mesa");
        }
    }

}
