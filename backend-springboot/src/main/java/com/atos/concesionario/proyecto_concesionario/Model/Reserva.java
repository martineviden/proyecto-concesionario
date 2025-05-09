package com.atos.concesionario.proyecto_concesionario.Model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservaId;

    private LocalDate fechaReserva;
    private int diasReserva;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private Double precioTotal;

    @ManyToOne
    @JsonBackReference("usuario-reserva")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne
    @JsonManagedReference("reserva-coche")
    @JoinColumn(name = "id_coche", unique = true)
    private Coche coche;

    @OneToOne
    @JsonManagedReference("reserva-furgoneta")
    @JoinColumn(name = "id_furgoneta", unique = true)
    private Furgoneta furgoneta;

    @OneToOne
    @JsonManagedReference("reserva-moto")
    @JoinColumn(name = "id_moto", unique = true)
    private Moto moto;

    @OneToOne
    @JsonManagedReference("reserva-resena")
    @JoinColumn(name = "id_resena", unique = true)
    private Resena resena;

    public enum Estado {
        CONFIRMADA,
        PENDIENTE,
        CANCELADA
    }

}