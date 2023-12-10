package com.example.ProyectoCENS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ProyectoCENS.dto.UsuarioDTO;
import com.example.ProyectoCENS.model.Rol;
import com.example.ProyectoCENS.model.Usuario; // Asegúrate de importar la clase correcta
import com.example.ProyectoCENS.repository.InRolService;
import com.example.ProyectoCENS.service.UsuarioServicio;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private InRolService rolesServicio;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/admin")
    public String adminUsuarios(Model model, Authentication authentication) {
        model.addAttribute("roles", rolesServicio.listarRol());
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "administrarUsuarios";
    }

    @PostMapping("/guardarUsuario")
    public String crearUsuario(@ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO,
            @ModelAttribute("roles") Collection<Rol> roles) {
        usuarioServicio.guardar(usuarioDTO, roles);
        return "redirect:/admin";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id, Model modelo) {
        usuarioServicio.eliminar(id);
        return "redirect:/admin";
    }

    @GetMapping("/editarUsuario/{id}")
    public String editarUsuario(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("roles", rolesServicio.listarRol());
        Optional<Usuario> usuario = usuarioServicio.findById(id);
        Usuario usuarioValorPredeterminado = new Usuario();
        Usuario usuarioDesenvuelto = usuario.orElse(usuarioValorPredeterminado);
        modelo.addAttribute("usuarioEditar", usuarioDesenvuelto);
        return "editarUsuario";
    }

    @PostMapping("/editar")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
        usuarioServicio.guardar(usuario);
        return "redirect:/admin";
    }

    @GetMapping("/misdatos")
    public String mostrarPerfil(Model model) {
        // Obtén la información de autenticación del contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Obtiene el principal del contexto de seguridad
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            // Si el principal es una instancia de UserDetails, puedes extraer la
            // información
            UserDetails userDetails = (UserDetails) principal;
            model.addAttribute("nombre", usuarioServicio.buscarPorRun(userDetails.getUsername()));
        }

        // Obtiene los roles (GrantedAuthorities) del usuario autenticado
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        model.addAttribute("roles", authorities);

        return "profile";
    }
  @GetMapping("/editarperfil/{run}")
  public String mostrarFormularioEdicion(@PathVariable String run, Model model)
  {
  // Obtener el usuario desde la base de datos según el RUN
  Usuario usuario = usuarioServicio.buscarPorRun(run);
  
  // Verificar si el usuario está presente
  if (usuario != null) {
  // Pasar el usuario al modelo para que el formulario pueda prellenar los campos
  model.addAttribute("usuarioActual", usuario);
  model.addAttribute("roles", rolesServicio.listarRol());
  
  // Puedes agregar cualquier otra información necesaria al modelo
  
  // Mostrar el formulario de edición
  }
  return "editprofile";

}
}

/*
 * @GetMapping("/listar")
 * public String listarUsuarios(Model modelo) {
 * modelo.addAttribute("usuario", new Usuario());
 * modelo.addAttribute("usuarios", servicioU.listarUsuario());
 * modelo.addAttribute("roles", servicioR.listarRol());
 * return "administrarUsuarios";
 * }
 * 
 * @PostMapping("/guardarUsuario")
 * public String crearUsuario(@ModelAttribute Usuario usuario) {
 * servicioU.guardar(usuario);
 * 
 * return "redirect:/listar";
 * }
 * 
 * @GetMapping("/editarUsuario/{id}")
 * public String editarUsuario(@PathVariable Long id, Model modelo) {
 * Optional<Usuario> usuario = servicioU.buscarUsuarioId(id);
 * Usuario usuarioValorPredeterminado = new Usuario(); // Puedes proporcionar un
 * valor predeterminado si el
 * // Optional está vacío
 * Usuario usuarioDesenvuelto = usuario.orElse(usuarioValorPredeterminado);
 * modelo.addAttribute("usuarioEditar", usuarioDesenvuelto);
 * modelo.addAttribute("roles", servicioR.listarRol());
 * return "editarUsuario";
 * }
 * 
 * 
 * 
 * }
 */
