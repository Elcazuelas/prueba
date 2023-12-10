package com.example.ProyectoCENS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoCENS.model.Empresa;
import com.example.ProyectoCENS.repository.EmpresaRepositorio;

@Service
public class EmpresaServicioImpl implements EmpresaServicio {

    @Autowired
    private final EmpresaRepositorio empresaRepositorio;

    public EmpresaServicioImpl(EmpresaRepositorio empresaRepositorio) {
        this.empresaRepositorio = empresaRepositorio;
    }

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepositorio.findAll();
    }

    @Override
    public Optional<Empresa> buscarPorId(Long id) {
        return empresaRepositorio.findById(id);
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return empresaRepositorio.save(empresa);
    }

    @Override
    public void eliminar(Long id) {
        empresaRepositorio.deleteById(id);
    }
}
