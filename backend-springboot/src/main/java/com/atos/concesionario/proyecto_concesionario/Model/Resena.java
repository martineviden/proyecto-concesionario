package com.atos.concesionario.proyecto_concesionario.Model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resenaId;

    private String texto;
    private int puntuacion;
    private LocalDate fecha;

    @ManyToOne
    @JsonBackReference("usuario-resena")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
}
