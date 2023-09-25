package org.example.service.impl;

import org.example.dto.MesaDto;
import org.example.jpa.MesaRepository;
import org.example.model.Mesa;
import org.example.service.EliminarMesaService;
import org.example.util.UtilCrearMesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EliminarMesaImpl implements EliminarMesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public ResponseEntity<String> deleteMesa(MesaDto mesaDto) {
        try {
            Optional<Mesa> mesaVerificar =
                    mesaRepository.findByNumero(mesaDto.getNumeroMesa());
            if (mesaVerificar.isPresent()) {
                mesaRepository.delete(mesaVerificar.get());
                return ResponseEntity.ok("Se ha eliminado la mesa");
            }else {
                return ResponseEntity.badRequest().body("El numero de mesa no existe para eliminado");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al eliminado el mesa");
        }
    }
}
