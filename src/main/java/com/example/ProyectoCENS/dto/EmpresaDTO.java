package com.example.ProyectoCENS.dto;

public class EmpresaDTO {
    private Long id;
    private String rut_empresa;
    private String razon_social;
    private String correo_empresa;
    private String telefono_empresa;
    private String nombre_representante;
    private String apellido_representante;
    private String correo_representante;
    private String telefono_representante;

    public EmpresaDTO(Long id, String rut_Empresa, String razon_Social, String correo_Empresa, String telefono_Empresa,
			String nombre_representante, String apellido_Representante, String correo_Representante,
			String telefono_Representante) {
		this.id = id;
		this.rut_empresa = rut_Empresa;
		this.razon_social = razon_Social;
		this.correo_empresa = correo_Empresa;
		this.telefono_empresa = telefono_Empresa;
		this.nombre_representante = nombre_representante;
		this.apellido_representante = apellido_Representante;
		this.correo_representante = correo_Representante;
		this.telefono_representante = telefono_Representante;
	}
    public EmpresaDTO(String rut_empresa){
        super();
        this.rut_empresa = rut_empresa;
    }

    public EmpresaDTO(){ 
    
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
