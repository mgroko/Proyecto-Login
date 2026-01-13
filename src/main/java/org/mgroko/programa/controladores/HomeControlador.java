package org.mgroko.programa.controladores;

import org.mgroko.programa.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeControlador {
    @GetMapping("/login")
    public String mostrarPaginaLogin(Model model) {

        System.out.println( "CONTROLADOR!!!!!!!!!!!!!!!!!!!!!!");


        model.addAttribute("datosLogin", new Usuario());
        return "login-register/login-page";
    }

}
