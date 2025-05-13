package com.atos.concesionario.proyecto_concesionario.Model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "resena")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resena {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String texto;

    @Column(columnDefinition = "INT CHECK (puntuacion >= 1 AND puntuacion <= 5)")
    private Integer puntuacion;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @OneToOne
    @JsonBackReference("reserva-resena")
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    
}
