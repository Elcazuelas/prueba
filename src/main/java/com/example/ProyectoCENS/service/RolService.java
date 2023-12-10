
 package com.example.ProyectoCENS.service;
 
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 
 import com.example.ProyectoCENS.model.Rol;
 import com.example.ProyectoCENS.repository.InRolService;
 import com.example.ProyectoCENS.repository.RolRepositorio;
 
 @Service
 public class RolService implements InRolService{
 
 
 @Autowired
 private RolRepositorio data;
 
 @Override
 public List<Rol> listarRol() {
 return data.findAll();
 }
 
 }
 