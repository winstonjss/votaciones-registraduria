package com.votaciones.registraduria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "voto")
public class Voto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "clase_voto")
    private String claseVoto;

    @Column(name = "cc_candidato")
    private String ccCandidato;

    @Column(name = "cantidad_votos")
    private Integer cantidadVotos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClaseVoto() {
        return claseVoto;
    }

    public void setClaseVoto(String claseVoto) {
        this.claseVoto = claseVoto;
    }

    public String getCcCandidato() {
        return ccCandidato;
    }

    public void setCcCandidato(String ccCandidato) {
        this.ccCandidato = ccCandidato;
    }

    public Integer getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(Integer cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }
}
