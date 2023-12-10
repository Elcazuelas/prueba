package com.example.ProyectoCENS.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProyectoCENS.dto.UsuarioDTO;
import com.example.ProyectoCENS.model.Rol;
import com.example.ProyectoCENS.service.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioServicio usuarioServicio;

    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("usuario")
    public UsuarioDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioDTO();
    }

    @GetMapping
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO, @ModelAttribute("roles") Collection<Rol> roles) {
        usuarioServicio.guardar(usuarioDTO, roles);
        return "redirect:/admin";
    }
}