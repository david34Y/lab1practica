package com.example.lab1practica.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "plataformas", schema = "gameshop3", catalog = "")
public class Plataforma {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idplataforma",nullable = false)
    private int idplataforma;
    @Basic
    @Column(name = "nombre" , length = 50)
    private String nombre;
    @Basic
    @Column(name = "descripcion" ,length = 200)
    private String descripcion;

    public int getIdplataforma() {
        return idplataforma;
    }

    public void setIdplataforma(int idplataforma) {
        this.idplataforma = idplataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
