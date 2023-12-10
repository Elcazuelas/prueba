package com.example.ProyectoCENS.dto;

public class UsuarioDTO {

    private Long id;
    private String run;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String email;
    private String telefono;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioDTO(Long id, String run, String nombre, String apellidoP, String apellidoM,
            String email,
            String telefono, String password) {
        super();
        this.id = id;
        this.run = run;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }

    public UsuarioDTO(String run, String nombre, String apellidoP, String apellidoM, String email,
            String telefono, String password) {
        super();
        this.run = run;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }

    public UsuarioDTO(String run) {
        super();
        this.run = run;
    }

    public UsuarioDTO() {
    }
}
