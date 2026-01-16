package org.mgroko.programa.servicio;

import org.mgroko.programa.modelo.Usuario;
import org.mgroko.programa.repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class LoginServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public LoginServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

public Usuario iniciarSesion(String user, String passwordIngresada) {

    Optional<Usuario> userOpt = usuarioRepositorio.findByUsername(user);

    if (userOpt.isEmpty()){
        throw new IllegalArgumentException("Usuario no encontrado");
    }

    Usuario usuario = userOpt.get();

    if (!usuario.getPassword().equals(passwordIngresada)){
        throw new IllegalArgumentException("Contraseña incorrecta");
    }

    System.out.println("LO LOGRE");
    return usuario;

}

}
