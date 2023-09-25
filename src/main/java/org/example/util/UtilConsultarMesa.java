package org.example.util;

import org.example.dto.MesaDto;
import org.example.model.Mesa;

import java.util.ArrayList;
import java.util.List;

public class UtilConsultarMesa {

    public List<MesaDto> listDtos(List<Mesa> list ){
        List<MesaDto> listDtos = new ArrayList<>();

        for(Mesa mesa : list){
            MesaDto mesaListDto = new MesaDto();
            mesaListDto.setNumeroMesa(mesa.getNumero());
            mesaListDto.setCantidadInscritos(mesa.getCantidadInscritos());
            listDtos.add(mesaListDto);
        }
        return listDtos;
    }
}
