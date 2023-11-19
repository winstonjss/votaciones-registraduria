package com.votaciones.registraduria.model;


import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
@Table(name = "mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cantidad_inscritos")
    private Integer cantidadInscritos;

    @Column(name = "numero")
    private Integer numero;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidadInscritos() {
        return cantidadInscritos;
    }

    public void setCantidadInscritos(Integer cantidadInscritos) {
        this.cantidadInscritos = cantidadInscritos;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Mesa(){super();}
    public Mesa(Integer id, Integer cantidadInscritos, Integer numero) {
        this.id = id;
        this.cantidadInscritos = cantidadInscritos;
        this.numero = numero;
    }
}