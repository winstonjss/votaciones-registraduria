package com.votaciones.registraduria.dto;

public class PartidoDto {
    private String lema;
    private String nombre;
    private String cantidadInscritos;
    private String numeroPartido;

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidadInscritos() {
        return cantidadInscritos;
    }

    public void setCantidadInscritos(String cantidadInscritos) {
        this.cantidadInscritos = cantidadInscritos;
    }

    public String getNumeroPartido() {
        return numeroPartido;
    }

    public void setNumeroPartido(String numeroPartido) {
        this.numeroPartido = numeroPartido;
    }
}