package org.example.service.impl;

import org.example.dto.MesaDto;
import org.example.jpa.MesaRepository;
import org.example.model.Mesa;
import org.example.service.ConsultarMesasService;
import org.example.util.UtilConsultarMesa;
import org.example.util.UtilCrearMesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultarMesasImpl implements ConsultarMesasService {
    @Autowired
    private MesaRepository mesaRepository;

    UtilConsultarMesa utilCrearMesa = new UtilConsultarMesa();

    @Override
    public ResponseEntity<List<MesaDto>> getAllMesa() {
        List<Mesa> list = (List<Mesa>) mesaRepository.findAll();
        return ResponseEntity.ok(utilCrearMesa.listDtos(list));
    }
}
