package org.mgroko.programa.modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;

    // todo VERIFICAR LA LONGITUD DEL usuario y contraseña

    @NotBlank(message = "La dirección es obligatoria")
    @Size(min = 5, max = 30, message = "El usuario debe tener entre 5 y 30 caracteres")
    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(min = 6, max = 30, message = "La contraseña debe tener entre 5 y 30 caracteres")
    @Column(name = "password", nullable = false, length = 30)
    private String password;



}
