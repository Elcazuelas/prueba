package com.example.ProyectoCENS.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.ProyectoCENS.dto.UsuarioDTO;
import com.example.ProyectoCENS.model.Rol;
import com.example.ProyectoCENS.model.Usuario;

public interface UsuarioServicio extends UserDetailsService {

    public Usuario guardar(UsuarioDTO usuarioDTO, Collection<Rol> roles);

    public List<Usuario> listarUsuarios();

    public Optional<Usuario> findByEmail(String email);

    public Optional<Usuario> findById(long id);

    public void eliminar(long id);

    public void guardar(Usuario usuario);

    public Usuario buscarPorRun(String run);

}
