package com.example.ProyectoCENS.service;

import java.util.List;
import java.util.Optional;

import com.example.ProyectoCENS.model.Empresa;

public interface EmpresaServicio {

    List<Empresa> listarEmpresas();

    Optional<Empresa> buscarPorId(Long id);

    Empresa guardar(Empresa empresa);

    void eliminar(Long id);
}
