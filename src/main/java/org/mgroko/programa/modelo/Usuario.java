package org.mgroko.programa.modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Collection;

@Data
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;

    // todo VERIFICAR LA LONGITUD DEL usuario y contraseña

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 5, max = 30, message = "El usuario debe tener entre 5 y 30 caracteres")
    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, max = 30, message = "La contraseña debe tener entre 5 y 30 caracteres")
    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El nombre solo puede contener letras y espacios")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El apellido solo puede contener letras y espacios")
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    // Relacion de muchos a muchos con usuario y rol. Creamos una tabla mediante un JoinTable para la relación
    // Se unen las columnas idUser e idRol.
    // Pongo CascadeType.ALL por el momento, pero no es recomendable
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "idRol")
    )
    private Collection<Rol> roles;

    public Usuario(String nombre, String apellido, String username, String password, Collection<Rol> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
