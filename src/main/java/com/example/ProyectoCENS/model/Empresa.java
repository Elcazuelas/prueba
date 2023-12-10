package com.example.ProyectoCENS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "empresa", uniqueConstraints = @UniqueConstraint(columnNames = "rut_Empresa"))
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rut_empresa;

    @Column(name = "nombre_empresa")
    private String nombre_empresa;

    @Column(name = "razon_social")
    private String razon_social;

    @Column(name = "correo_empresa")
    private String correo_empresa;

    @Column(name = "telefono_empresa")
    private String telefono_empresa;

    @Column(name = "nombre_representante")
    private String nombre_representante;

    @Column(name = "apellido_representante")
    private String apellido_representante;

    @Column(name = "correo_representante")
    private String correo_representante;

    @Column(name = "telefono_representante")
    private String telefono_representante;

    public Empresa(Long id, String rut_Empresa, String nombre_Empresa, String razon_Social, String correo_Empresa,
            String telefono_Empresa, String nombre_representante, String apellido_Representante,
            String correo_Representante, String telefono_Representante) {
        super();
        this.id = id;
        this.rut_empresa = rut_Empresa;
        this.nombre_empresa = nombre_Empresa;
        this.razon_social = razon_Social;
        this.correo_empresa = correo_Empresa;
        this.telefono_empresa = telefono_Empresa;
        this.nombre_representante = nombre_representante;
        this.apellido_representante = apellido_Representante;
        this.correo_representante = correo_Representante;
        this.telefono_representante = telefono_Representante;
    }

    public Empresa(String rut_Empresa, String nombre_Empresa, String razon_Social, String correo_Empresa,
            String telefono_Empresa, String nombre_representante, String apellido_Representante,
            String correo_Representante, String telefono_Representante) {
        super();
        this.rut_empresa = rut_Empresa;
        this.nombre_empresa = nombre_Empresa;
        this.razon_social = razon_Social;
        this.correo_empresa = correo_Empresa;
        this.telefono_empresa = telefono_Empresa;
        this.nombre_representante = nombre_representante;
        this.apellido_representante = apellido_Representante;
        this.correo_representante = correo_Representante;
        this.telefono_representante = telefono_Representante;
    }

    public Empresa(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut_empresa() {
        return rut_empresa;
    }

    public void setRut_empresa(String rut_empresa) {
        this.rut_empresa = rut_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getCorreo_empresa() {
        return correo_empresa;
    }

    public void setCorreo_empresa(String correo_empresa) {
        this.correo_empresa = correo_empresa;
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    public String getNombre_representante() {
        return nombre_representante;
    }

    public void setNombre_representante(String nombre_representante) {
        this.nombre_representante = nombre_representante;
    }

    public String getApellido_representante() {
        return apellido_representante;
    }

    public void setApellido_representante(String apellido_representante) {
        this.apellido_representante = apellido_representante;
    }

    public String getCorreo_representante() {
        return correo_representante;
    }

    public void setCorreo_representante(String correo_representante) {
        this.correo_representante = correo_representante;
    }

    public String getTelefono_representante() {
        return telefono_representante;
    }

    public void setTelefono_representante(String telefono_representante) {
        this.telefono_representante = telefono_representante;
    }


}
