package com.votaciones.registraduria.dto;

public class VotosListDto {
    private String claseVoto;
    private String candidato;
    private String partido;
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

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public Integer getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(Integer cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }
}
