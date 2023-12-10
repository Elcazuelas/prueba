package com.example.ProyectoCENS.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/")
    public String verPaginaInicio(Model model) {
        // Obtén la información de autenticación del contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Obtiene el principal del contexto de seguridad
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            // Si el principal es una instancia de UserDetails, puedes extraer la
            // información
            UserDetails userDetails = (UserDetails) principal;
            model.addAttribute("nombre", userDetails.getUsername());
        }

        // Obtiene los roles (GrantedAuthorities) del usuario autenticado
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        model.addAttribute("roles", authorities);

        return "main";
    }
}

/*
 * import java.util.Collection;
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Controller;
 * import org.springframework.ui.Model;
 * import org.springframework.web.bind.annotation.GetMapping;
 * import org.springframework.web.bind.annotation.ModelAttribute;
 * import org.springframework.web.bind.annotation.PathVariable;
 * import org.springframework.web.bind.annotation.PostMapping;
 * 
 * import com.example.ProyectoCENS.model.Rol;
 * import com.example.ProyectoCENS.model.Usuario;
 * import com.example.ProyectoCENS.service.Autenticacion;
 * import com.example.ProyectoCENS.service.RolService;
 * import com.example.ProyectoCENS.service.UsuarioService;
 * import com.example.ProyectoCENS.repository.UsuarioRepositorio;
 * 
 * @Controller
 * public class LoginController {
 * 
 * @Autowired
 * private Autenticacion autenticacion;
 * 
 * @Autowired
 * private RolService servicioR;
 * 
 * @Autowired
 * private UsuarioService servicioU;
 * 
 * @GetMapping("/login")
 * public String showLoginPage() {
 * return "login";
 * }
 * 
 * @GetMapping("/misdatos/{run}")
 * public String mostrarPerfil(@PathVariable String run, Model model) {
 * // Buscar el usuario en la base de datos según el RUN (ahora es una cadena)
 * Usuario usuario = usuarioRepositorio.findByRun(run);
 * 
 * // Verificar si el usuario está presente
 * if (usuario != null) {
 * // Pasar el usuario al modelo
 * model.addAttribute("usuarioActual", usuario);
 * // Redirigir a la página de perfil
 * return "profile";
 * } else {
 * // El usuario no está presente, manejar según tus requisitos
 * return "main";
 * }
 * }
 * 
 * @GetMapping("/inicio")
 * public String showMainPage() {
 * return "main";
 * }
 * 
 * 
 * }
 * 
 * @PostMapping("/confirmaredicion")
 * public String confirmarEdicion(@ModelAttribute Usuario usuarioActual) {
 * // Aquí deberías realizar la lógica para actualizar la información del
 * usuario
 * // en la base de datos
 * // Puedes llamar a un servicio o al repositorio para actualizar la
 * información
 * 
 * servicioU.guardar(usuarioActual);
 * 
 * // Después de guardar los cambios, puedes redirigir a la página de perfil
 * // actualizada
 * return "redirect:/misdatos/" + usuarioActual.getRun();
 * }
 * 
 * @Autowired
 * private UsuarioRepositorio usuarioRepositorio;
 * 
 * @PostMapping("/login")
 * public String doLogin(String run, String password, Model model) {
 * 
 * if (autenticacion.autenticacion(run, password)) {
 * // Buscar el usuario en la base de datos según el RUN (ahora es una cadena)
 * Usuario usuario = usuarioRepositorio.findByRun(run);
 * 
 * // Verificar si el usuario está presente
 * if (usuario != null) {
 * // Pasar el usuario al modelo
 * model.addAttribute("usuarioActual", usuario);
 * 
 * Collection<Rol> roles = usuario.getRoles();
 * if (roles.isEmpty()) {
 * return "redirect:/misdatos/" + run;
 * }
 * 
 * Rol primerRol = roles.iterator().next();
 * String nombreRol = primerRol.getNombre();
 * 
 * switch (nombreRol) {
 * case "Administrador":
 * return "redirect:/listar";
 * case "Visador":
 * case "Evaluador":
 * return "redirect:/misdatos/" + run;
 * default:
 * return "login";
 * }
 * }
 * }
 * 
 * model.addAttribute("error", "Credenciales Incorrectas");
 * return "login";
 * }
 * 
 * }
 */
