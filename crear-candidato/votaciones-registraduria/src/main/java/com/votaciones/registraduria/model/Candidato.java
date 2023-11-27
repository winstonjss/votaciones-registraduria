package com.votaciones.registraduria.model;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
@Table(name = "candidato")
public class Candidato {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "partido",referencedColumnName = "id", nullable = false)
    private Partido partido;
    public Candidato(){
        super();
    }

    public Candidato(Integer id, String cedula, String numeroResolucion, String nombre, String apellido) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
