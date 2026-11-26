package com.adrianfernandez.ticketflow.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Incidencia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 150)
    private String titulo;


    @Column(nullable = false, length = 2000)
    private String descripcion;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;


    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaDeCreacion;


    public Incidencia() {
    }


//Metodo que establece la fecha actual y el estado "PENDIENTE" por defecto al crear una incidencia

    @PrePersist
    void alCrear() {
        this.fechaDeCreacion = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = Estado.PENDIENTE;
        }
    }


//GETTERS & SETTERS

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }
}