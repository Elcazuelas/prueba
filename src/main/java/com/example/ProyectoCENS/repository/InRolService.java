
 package com.example.ProyectoCENS.repository;
 
 import java.util.List;
 
 import org.springframework.stereotype.Repository;
 
 import com.example.ProyectoCENS.model.Rol;
 
 @Repository
 public interface InRolService {
 public List<Rol>listarRol();
 }
 