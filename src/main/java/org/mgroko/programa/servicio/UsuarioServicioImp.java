package org.mgroko.programa.servicio;

import org.mgroko.programa.modelo.Rol;
import org.mgroko.programa.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mgroko.programa.modelo.Usuario;
import org.mgroko.programa.dto.UsuarioRegistroDTO;

import java.util.Arrays;

@Service
public class UsuarioServicioImp implements UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImp(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario save(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getUsername(), registroDTO.getPassword(), Arrays.asList(new Rol("ROLE_USER")));

        return usuarioRepositorio.save(usuario);
    }

}
