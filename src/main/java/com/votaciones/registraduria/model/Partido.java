package com.votaciones.registraduria.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "partido")
public class Partido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "lema")
    private String lema;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad_inscritos")
    private String cantidadInscritos;

    @Column(name = "numero")
    private Integer numero;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
