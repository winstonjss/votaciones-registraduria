package org.example.util;

import org.example.dto.MesaDto;
import org.example.model.Mesa;

public class UtilCrearMesa {

    public Mesa crearMesa(MesaDto mesaDto){
        Mesa mesa = new Mesa();
        mesa.setNumero(mesaDto.getNumeroMesa());
        mesa.setCantidadInscritos(mesaDto.getCantidadInscritos());
        return mesa;
    }
}
