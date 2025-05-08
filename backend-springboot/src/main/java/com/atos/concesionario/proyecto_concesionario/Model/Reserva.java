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

    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String estado;
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

}