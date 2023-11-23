package com.votaciones.registraduria.service.impl;

import com.votaciones.registraduria.dto.PartidoDto;
import com.votaciones.registraduria.jpa.PartidoRepository;
import com.votaciones.registraduria.model.Partido;
import com.votaciones.registraduria.service.PartidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartidoImpl implements PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    @Override
    public ResponseEntity<String> createPartido(PartidoDto partidoDto) {
        try {

            Optional<Partido> partidoVerificar =
                    partidoRepository.findByNumero(Integer.parseInt(partidoDto.getNumeroPartido()));
            if (!partidoVerificar.isPresent()) {
                Partido partido = new Partido();
                partido.setNombre(partidoDto.getNombre());
                partido.setLema(partidoDto.getLema());
                partido.setNumero(Integer.parseInt(partidoDto.getNumeroPartido()));
                partido.setCantidadInscritos(partidoDto.getCantidadInscritos());
                partidoRepository.save(partido);
                return ResponseEntity.ok("Se ha creado el partido");
            }else {
                return ResponseEntity.badRequest().body("El numero de partido ya existe");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al crear el partido");
        }
    }

    @Override
    public ResponseEntity<List<PartidoDto>> getAllPartido() {
        List<Partido> list = (List<Partido>) partidoRepository.findAll();

        List<PartidoDto> listDtos = new ArrayList<>();

        for(Partido partido : list){
            PartidoDto partidoDto = new PartidoDto();
            partidoDto.setLema(partido.getLema());
            partidoDto.setNumeroPartido(partido.getNumero().toString());
            partidoDto.setCantidadInscritos(partido.getCantidadInscritos());
            partidoDto.setNombre(partido.getNombre());
            listDtos.add(partidoDto);
        }

        return ResponseEntity.ok(listDtos);
    }

    @Override
    public ResponseEntity<String> updatePartido(PartidoDto partidoDto) {
        try {

            Optional<Partido> partidoVerificar =
                    partidoRepository.findByNumero(Integer.parseInt(partidoDto.getNumeroPartido()));
            if (partidoVerificar.isPresent()) {
                Partido partido = new Partido();
                partido.setId(partidoVerificar.get().getId());
                partido.setNombre(partidoDto.getNombre());
                partido.setLema(partidoDto.getLema());
                partido.setNumero(Integer.parseInt(partidoDto.getNumeroPartido()));
                partido.setCantidadInscritos(partidoDto.getCantidadInscritos());
                partidoRepository.save(partido);
                return ResponseEntity.ok("Se ha editado el partido");
            }else {
                return ResponseEntity.badRequest().body("El numero de partido no existe para editar");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al editar el partido");
        }
    }

    @Override
    public ResponseEntity<String> deletePartido(String partidoDto) {
        try {
            Optional<Partido> partidoVerificar =
                    partidoRepository.findByNumero(Integer.parseInt(partidoDto));
            if (partidoVerificar.isPresent()) {
                partidoRepository.delete(partidoVerificar.get());
                return ResponseEntity.ok("Se ha eliminado el partido");
            }else {
                return ResponseEntity.badRequest().body("El numero de partido no existe para eliminado");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al eliminar el partido");
        }
    }
}