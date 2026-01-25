package org.mgroko.programa.servicio;

import org.mgroko.programa.dto.UsuarioRegistroDTO;
import org.mgroko.programa.modelo.Rol;
import org.mgroko.programa.modelo.Usuario;
import org.mgroko.programa.repositorios.RolRepositorio;
import org.mgroko.programa.repositorios.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service

public class AutenticadorServicioImp implements AutenticadorServicio {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;
    private final RolRepositorio rolRepositorio;


    public AutenticadorServicioImp(UsuarioRepositorio usuarioRepositorio , PasswordEncoder passwordEncoder, RolRepositorio rolRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
        this.rolRepositorio = rolRepositorio;
    }

public Usuario iniciarSesion(String user, String passwordIngresada) {

    Optional<Usuario> userOpt = usuarioRepositorio.findByUsername(user);

    if (userOpt.isEmpty()){
        throw new IllegalArgumentException("Usuario no encontrado");
    }

    Usuario usuario = userOpt.get();

    if (!passwordEncoder.matches(passwordIngresada, usuario.getPassword())) {
        throw new IllegalArgumentException("Contraseña incorrecta");
    }

    System.out.println("LO LOGRE");
    return usuario;

}

    @Override
    public Usuario registerUser(UsuarioRegistroDTO registroDTO) {

        if (usuarioRepositorio.existsByUsername(registroDTO.getUsername())) {
            throw new IllegalArgumentException("El nombre de usuario no está disponible");
        }

        Rol rol = rolRepositorio.findByNombre("ROLE_USER");

        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getApellido(),
                registroDTO.getUsername(),
                passwordEncoder.encode(registroDTO.getPassword()),
                Arrays.asList(rol));

        return usuarioRepositorio.save(usuario);
    }


}
