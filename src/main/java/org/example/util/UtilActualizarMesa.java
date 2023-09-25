package org.example.util;

import org.example.dto.MesaDto;
import org.example.model.Mesa;

public class UtilActualizarMesa {

    public Mesa actualizarMesa(MesaDto mesaDto, Integer id){
        Mesa mesa = new Mesa();
        mesa.setId(id);
        mesa.setNumero(mesaDto.getNumeroMesa());
        mesa.setCantidadInscritos(mesaDto.getCantidadInscritos());
        return mesa;
    }
}
