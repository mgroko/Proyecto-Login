package org.mgroko.programa.servicio;

import org.mgroko.programa.repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicioImp implements UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImp(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


}
