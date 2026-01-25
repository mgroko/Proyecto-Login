package org.mgroko.programa.controladores;

import jakarta.validation.Valid;
import org.mgroko.programa.dto.UsuarioRegistroDTO;
import org.mgroko.programa.servicio.AutenticadorServicio;
import org.mgroko.programa.servicio.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private final AutenticadorServicio autenticadorServicio;

    public RegistroUsuarioControlador(AutenticadorServicio autenticadorServicio) {
        this.autenticadorServicio = autenticadorServicio;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "login-register/register-page";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") @Valid UsuarioRegistroDTO registroDTO, BindingResult result) {

        if (result.hasErrors()) {
            return "login-register/register-page";
        }

        try {
            autenticadorServicio.registerUser(registroDTO);
            return "redirect:/registro?exito";

        }  catch (Exception e) {
            return "redirect:/registro?error=true";
        }
    }

}
