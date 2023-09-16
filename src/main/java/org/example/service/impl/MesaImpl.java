package org.example.service.impl;

import org.example.dto.MesaDto;
import org.example.jpa.MesaRepository;
import org.example.model.Candidato;
import org.example.model.Mesa;
import org.example.model.Partido;
import org.example.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MesaImpl implements MesaService {

    @Autowired
    private MesaRepository mesaRepository;
    @Override
    public ResponseEntity<String> createMesa(MesaDto mesaDto) {
        try {
            Optional<Mesa> verificarMesa =
                    mesaRepository.findByNumero(mesaDto.getNumeroMesa());
            if (!verificarMesa.isPresent()) {
                Mesa mesa = new Mesa();
                mesa.setNumero(mesaDto.getNumeroMesa());
                mesa.setCantidadInscritos(mesaDto.getCantidadInscritos());
                mesaRepository.save(mesa);
                return ResponseEntity.ok("Se ha creado la mesa");
            }else {
                return ResponseEntity.badRequest().body("El numero de mesa ya existe");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al crear la mesa");
        }
    }

    @Override
    public ResponseEntity<List<MesaDto>> getAllMesa() {
        List<Mesa> list = (List<Mesa>) mesaRepository.findAll();

        List<MesaDto> listDtos = new ArrayList<>();

        for(Mesa mesa : list){
            MesaDto mesaListDto = new MesaDto();
            mesaListDto.setNumeroMesa(mesa.getNumero());
            mesaListDto.setCantidadInscritos(mesa.getCantidadInscritos());
            listDtos.add(mesaListDto);
        }

        return ResponseEntity.ok(listDtos);
    }

    @Override
    public ResponseEntity<String> updateMesa(MesaDto mesaDto) {
        try {
            Optional<Mesa> verificarMesa =
                    mesaRepository.findByNumero(mesaDto.getNumeroMesa());
            if (verificarMesa.isPresent()) {
                Mesa mesa = new Mesa();
                mesa.setId(verificarMesa.get().getId());
                mesa.setNumero(mesaDto.getNumeroMesa());
                mesa.setCantidadInscritos(mesaDto.getCantidadInscritos());
                mesaRepository.save(mesa);
                return ResponseEntity.ok("Se ha editado la mesa");
            }else {
                return ResponseEntity.badRequest().body("El numero de mesa ya existe");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al editado la mesa");
        }
    }

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
