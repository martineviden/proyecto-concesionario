package com.atos.concesionario.proyecto_concesionario.Model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

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
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
}
