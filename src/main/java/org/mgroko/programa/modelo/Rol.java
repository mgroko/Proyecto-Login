package org.mgroko.programa.modelo;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "rol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Rol {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long idRol;

        @Column(name = "nombre", nullable = false, length = 100)
        private String nombre;

        public Rol(String nombre) {
                this.nombre = nombre;
        }
}
