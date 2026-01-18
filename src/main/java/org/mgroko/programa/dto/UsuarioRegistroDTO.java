package org.mgroko.programa.dto;
import lombok.*;
import org.mgroko.programa.modelo.Usuario;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioRegistroDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String username;
    private String password;

    public UsuarioRegistroDTO(String nombre, String apellido, String username, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
    }
    public UsuarioRegistroDTO(String username) {
        this.username = username;
    }
}
