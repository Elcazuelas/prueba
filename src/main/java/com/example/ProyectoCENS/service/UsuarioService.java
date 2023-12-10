/*
 * package com.example.ProyectoCENS.service;
 * 
 * import java.util.List;
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Service;
 * 
 * import com.example.ProyectoCENS.model.Usuario;
 * import com.example.ProyectoCENS.repository.InUsuarioService;
 * import com.example.ProyectoCENS.repository.UsuarioRepositorio;
 * 
 * @Service
 * public class UsuarioService implements InUsuarioService {
 * 
 * @Autowired
 * private UsuarioRepositorio usRepositorio;
 * 
 * @Override
 * public List<Usuario> listarUsuario() {
 * return usRepositorio.findAll();
 * }
 * 
 * @Override
 * public Optional<Usuario> buscarUsuarioId(long id) {
 * return usRepositorio.findById(id);
 * }
 * 
 * @Override
 * public void guardar(Usuario usuario) {
 * usRepositorio.save(usuario);
 * }
 * 
 * @Override
 * public void eliminar(long id) { // elimina por id
 * usRepositorio.deleteById(id);
 * }
 * 
 * @Override
 * public Optional<Usuario> findByEmail(String email) {
 * return usRepositorio.findByEmail(email);
 * }
 * 
 * }
 */