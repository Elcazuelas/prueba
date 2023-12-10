package com.example.ProyectoCENS.service;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ProyectoCENS.dto.UsuarioDTO;
import com.example.ProyectoCENS.model.Rol;
import com.example.ProyectoCENS.model.Usuario;
import com.example.ProyectoCENS.repository.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario guardar(UsuarioDTO registroDTO, Collection<Rol> roles) {
        Usuario usuario = new Usuario(registroDTO.getRun(), registroDTO.getNombre(), registroDTO.getApellidoP(),
                registroDTO.getApellidoM(), registroDTO.getEmail(), registroDTO.getTelefono(),
                passwordEncoder.encode(registroDTO.getPassword()), roles);
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByRun(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña invalidos");
        }
        return new User(usuario.getRun(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

    @Override
    public void eliminar(long id) { // elimina por id
        usuarioRepositorio.deleteById(id);
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioRepositorio.findById(id);
    }

    @Override
    public void guardar(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

     @Override
    public Usuario buscarPorRun(String run) {
        return usuarioRepositorio.findByRun(run);
    }
}
