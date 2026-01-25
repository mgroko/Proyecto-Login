package org.mgroko.programa.servicio;

import org.mgroko.programa.dto.UsuarioRegistroDTO;
import org.mgroko.programa.modelo.Usuario;

public interface AutenticadorServicio {

    Usuario registerUser(UsuarioRegistroDTO registroDTO);
    Usuario iniciarSesion(String usuario, String password);

}
