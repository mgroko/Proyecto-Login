package org.mgroko.programa.controladores;

import org.mgroko.programa.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeControlador {
    @GetMapping("/")
    public String mostrarPaginaInicio() {

        return "redirect:/login";

    }
    @GetMapping("/login")
    public String muestroLogin(Model model){

        model.addAttribute("datosLogin", new Usuario());
        return "login-register/login-page";


    }
}
