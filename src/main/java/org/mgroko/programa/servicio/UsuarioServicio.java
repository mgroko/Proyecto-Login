package org.mgroko.programa.servicio;

import org.mgroko.programa.modelo.Usuario;
import org.mgroko.programa.dto.UsuarioRegistroDTO;

public interface UsuarioServicio {

    public Usuario save(UsuarioRegistroDTO registroDTO);

}
