package com.atos.concesionario.proyecto_concesionario.Model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    private String nombre;
    private String apellidos;
    private String correo;
    private String contrasena;
    private String telefono;
    private String fotoPerfil;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference("usuario-reserva")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference("usuario-resena")
    private List<Resena> resenas;

    public enum Rol {
        CLIENTE, ADMIN
    }
    
}