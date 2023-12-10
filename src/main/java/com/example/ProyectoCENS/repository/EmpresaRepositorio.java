package com.example.ProyectoCENS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoCENS.model.Empresa;;
@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa,Long>{
    
}
