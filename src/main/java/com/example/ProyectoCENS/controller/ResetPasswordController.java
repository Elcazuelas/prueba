package com.example.ProyectoCENS.controller;

import com.example.ProyectoCENS.model.Usuario;
import com.example.ProyectoCENS.service.EmailService;
import com.example.ProyectoCENS.service.UsuarioServicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResetPasswordController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/resetPassword")
    public String showResetPass() {
        return "ResetPassword";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam("email") String email, Model model) {
        // Recupera el usuario por correo electrónico
        Optional<Usuario> optionalUsuario = usuarioServicio.findByEmail(email);

        if (optionalUsuario.isPresent()) {
            // Obtiene la contraseña del usuario
            Usuario usuario = optionalUsuario.get();
            String nombreCompleto = usuario.getNombre() + " " + usuario.getApellidoP() +
                    " "
                    + usuario.getApellidoM();
            String password = usuario.getPassword();

            // Construye el cuerpo del correo
            String emailBody = "Estimado " + nombreCompleto
                    +
                    ".\nSe realizó una petición para recuperar su contraseña en el sistema CENS.\nSu contraseña es: "
                    + password;

            // Enviar el correo
            emailService.sendEmail(email, "Recuperación Contraseña CENS", emailBody);

            model.addAttribute("success",
                    "Envío de contraseña exitoso al correo electronico.");
            return "resetPassword";
        } else {
            model.addAttribute("error",
                    "El correo electronico no está asociado a ninguna cuenta.");
            return "resetPassword";
        }
    }
}
