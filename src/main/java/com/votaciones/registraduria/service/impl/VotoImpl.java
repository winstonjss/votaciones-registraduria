package com.votaciones.registraduria.service.impl;

import com.votaciones.registraduria.dto.CandidatoDto;
import com.votaciones.registraduria.dto.CandidatoListDto;
import com.votaciones.registraduria.dto.VotosDto;
import com.votaciones.registraduria.dto.VotosListDto;
import com.votaciones.registraduria.jpa.CandidatoRepository;
import com.votaciones.registraduria.jpa.VotoRepository;
import com.votaciones.registraduria.model.Candidato;
import com.votaciones.registraduria.model.Voto;
import com.votaciones.registraduria.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VotoImpl implements VotoService {

    @Autowired
    private VotoRepository votoRepository;
    @Autowired
    private CandidatoRepository candidatoRepository;
    @Override
    public ResponseEntity<String> registraVoto(VotosDto votosDto) {
        Optional<Candidato> cc = candidatoRepository.findByCedula(votosDto.getCandidato());

        if(cc.isPresent()) {
            Voto voto = new Voto();
            voto.setCantidadVotos(votosDto.getCantidadVotos());
            voto.setClaseVoto(votosDto.getClaseVoto());
            voto.setCcCandidato(votosDto.getCandidato());
            votoRepository.save(voto);

            return ResponseEntity.ok("Voto registado");
        }else {
            return ResponseEntity.ok("Cedula no existe");
        }
    }

    @Override
    public ResponseEntity<List<VotosListDto>> getAllVotos() {
        List<Voto> list = (List<Voto>) votoRepository.findAll();

        List<VotosListDto> listDtos = new ArrayList<>();

        for(Voto votos: list){
            Optional<Candidato> candidato = candidatoRepository.findByCedula(votos.getCcCandidato());
            VotosListDto votosListDto = new VotosListDto();
            votosListDto.setPartido(candidato.get().getPartido().getNombre());
            votosListDto.setCandidato(candidato.get().getNombre());
            votosListDto.setCantidadVotos(votos.getCantidadVotos());
            votosListDto.setClaseVoto(votos.getClaseVoto());
            listDtos.add(votosListDto);
        }
        return ResponseEntity.ok(listDtos);
    }
}
