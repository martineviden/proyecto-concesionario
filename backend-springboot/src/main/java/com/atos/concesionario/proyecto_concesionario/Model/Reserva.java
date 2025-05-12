package com.atos.concesionario.proyecto_concesionario.Model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matricula", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "dias_reserva", nullable = false)
    private Integer diasReserva;

    @Column(nullable = false)
    private Double precio;

}