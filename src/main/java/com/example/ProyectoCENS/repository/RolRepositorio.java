package com.example.ProyectoCENS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoCENS.model.Rol;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Long> {

}
