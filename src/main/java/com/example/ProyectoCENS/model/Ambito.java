package com.example.ProyectoCENS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ambito")
public class Ambito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_ambito")
    private String nombre_ambito;

    @OneToMany(mappedBy = "ambito")
    private List<Subambito> Subambitos = new ArrayList<>();

    public Ambito(Long id, String nombre_ambito, List<Subambito> subambitos) {
        super();
        this.id = id;
        this.nombre_ambito = nombre_ambito;
        Subambitos = subambitos;
    }

    public Ambito(String nombre_ambito, List<Subambito> subambitos) {
        super();
        this.nombre_ambito = nombre_ambito;
        Subambitos = subambitos;
    }

    public Ambito() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_ambito() {
        return nombre_ambito;
    }

    public void setNombre_ambito(String nombre_ambito) {
        this.nombre_ambito = nombre_ambito;
    }

    public List<Subambito> getSubambitos() {
        return Subambitos;
    }

    public void setSubambitos(List<Subambito> subambito) {
        Subambitos = subambito;
    }

}
