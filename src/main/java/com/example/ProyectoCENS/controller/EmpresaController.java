package com.example.ProyectoCENS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ProyectoCENS.model.Empresa;
import com.example.ProyectoCENS.service.EmpresaServicio;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaServicio empresaServicio;

    @GetMapping("/listarEmpresas")
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        List<Empresa> empresas = empresaServicio.listarEmpresas();
        return ResponseEntity.ok().body(empresas); // Ajusta según tu ruta y vista
    }

    @GetMapping("/administrarEmpresas")
    public String adminempre() {
        return "administrarEmpresas";
    }

    @GetMapping("/verEmpresa/{id}")
    public String verEmpresa(@PathVariable Long id, Model model) {
        Optional<Empresa> empresa = empresaServicio.buscarPorId(id);
        empresa.ifPresent(value -> model.addAttribute("empresa", value));
        return "administrarEmpresas"; // Ajusta según tu ruta y vista
    }

    @GetMapping("/editarEmpresa/{id}")
    public String editarEmpresa(@PathVariable Long id, Model model) {
        Optional<Empresa> empresa = empresaServicio.buscarPorId(id);
        Empresa empresaValorPredeterminado = new Empresa();
        Empresa empresaDesenvuelto = empresa.orElse(empresaValorPredeterminado);
        model.addAttribute("empresaEditar", empresaDesenvuelto);
        return "editarEmpresa";
    }

    @PostMapping("/editarEmpresa")
    public String crearEmpresa(@ModelAttribute Empresa empresa) {
        empresaServicio.guardar(empresa);
        return "redirect:/administrarEmpresas";
    }

    @PostMapping("/guardarEmpresa")
    public String guardarEmpresa(@ModelAttribute Empresa empresa) {
        empresaServicio.guardar(empresa);
        return "redirect:/administrarEmpresas"; // Ajusta según tu ruta
    }

    @GetMapping("/eliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Long id) {
        empresaServicio.eliminar(id);
        return "redirect:/administrarEmpresas"; // Ajusta según tu ruta
    }
}
