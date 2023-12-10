package com.example.ProyectoCENS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.example.ProyectoCENS.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByRun(String run);

    Optional<Usuario> findById(long id);

    Optional<Usuario> findByEmail(String email);

    void deleteById(long id);

}
