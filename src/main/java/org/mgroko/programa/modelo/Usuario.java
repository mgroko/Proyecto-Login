package org.mgroko.programa.modelo;
import jakarta.persistence.*;
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

    @Column(name = "username", nullable = false, length =30)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    // Relacion de muchos a muchos con usuario y rol. Creamos una tabla mediante un JoinTable para la relación
    // Se unen las columnas idUser e idRol.
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
