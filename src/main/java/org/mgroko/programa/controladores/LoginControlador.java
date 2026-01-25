package org.mgroko.programa.controladores;

import org.mgroko.programa.modelo.Usuario;
import org.mgroko.programa.servicio.AutenticadorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginControlador {

    private final AutenticadorServicio autenticadorServicio;
    public LoginControlador(AutenticadorServicio autenticadorServicio) {
        this.autenticadorServicio = autenticadorServicio;
    }

@PostMapping("/login")
    public String inicioSesion(@ModelAttribute Usuario usuario) {
        try {
            autenticadorServicio.iniciarSesion(usuario.getUsername(), usuario.getPassword());
            return "redirect:/login?exito";
        } catch (Exception e) {
            return "redirect:/login?error=" + e.getMessage();
        }

}

}
