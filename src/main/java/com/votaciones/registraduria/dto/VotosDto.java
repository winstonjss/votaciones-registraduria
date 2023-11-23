package com.votaciones.registraduria.dto;

public class VotosDto {

    private String claseVoto;
    private String candidato;
    private Integer cantidadVotos;

    public String getClaseVoto() {
        return claseVoto;
    }

    public void setClaseVoto(String claseVoto) {
        this.claseVoto = claseVoto;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }


    public Integer getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(Integer cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }
}
