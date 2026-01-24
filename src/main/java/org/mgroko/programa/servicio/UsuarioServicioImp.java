package org.mgroko.programa.servicio;

import org.mgroko.programa.modelo.Rol;
import org.mgroko.programa.repositorios.RolRepositorio;
import org.mgroko.programa.repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.mgroko.programa.modelo.Usuario;
import org.mgroko.programa.dto.UsuarioRegistroDTO;

import java.util.Arrays;

@Service
public class UsuarioServicioImp implements UsuarioServicio {

    private final RolRepositorio rolRepositorio;
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImp(UsuarioRepositorio usuarioRepositorio, RolRepositorio rolRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.rolRepositorio = rolRepositorio;
    }

    @Override
    public Usuario registerUser(UsuarioRegistroDTO registroDTO) {

        if (usuarioRepositorio.existsByUsername(registroDTO.getUsername())) {
            throw new IllegalArgumentException("El nombre de usuario no está disponible");
        }

        Rol rol = rolRepositorio.findByNombre("ROL_USER");

        Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getUsername(), registroDTO.getPassword(), Arrays.asList(rol));
        return usuarioRepositorio.save(usuario);
    }

}
