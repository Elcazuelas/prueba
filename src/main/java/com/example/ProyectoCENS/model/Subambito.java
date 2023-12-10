package com.example.ProyectoCENS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Subambito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_subamibto")
    private String nombre_subambito;


    @ManyToOne
    @JoinColumn(name = "ambito_id")
    private Ambito ambito;

    public Subambito(Long id, String nombre_subambito, Ambito ambito) {
        super();
        this.id = id;
        this.nombre_subambito = nombre_subambito;
        this.ambito = ambito;
    }

    public Subambito(String nombre_subambito, Ambito ambito) {
        super();
        this.nombre_subambito = nombre_subambito;
        this.ambito = ambito;
    }

    public Subambito() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_subambito() {
        return nombre_subambito;
    }

    public void setNombre_subambito(String nombre_subambito) {
        this.nombre_subambito = nombre_subambito;
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
    }

}
