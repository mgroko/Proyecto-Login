package org.mgroko.programa.controladores;

import ch.qos.logback.core.model.Model;
import org.mgroko.programa.modelo.Usuario;
import org.mgroko.programa.servicio.LoginServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginControlador {

    private LoginServicio loginServicio;
    public LoginControlador(LoginServicio loginServicio) {this.loginServicio = loginServicio;}

@PostMapping("/login")
    public String inicioSesion(@ModelAttribute Usuario usuario) {
        try {
            loginServicio.iniciarSesion(usuario.getUsername(), usuario.getPassword());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/login" + "?error=" + e.getMessage();
        }

}

}
