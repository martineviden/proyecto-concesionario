package com.atos.concesionario.proyecto_concesionario.Model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

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
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_coche", unique = true)
    private Coche coche;

    @OneToOne
    @JoinColumn(name = "id_furgoneta", unique = true)
    private Furgoneta furgoneta;

    @OneToOne
    @JoinColumn(name = "id_moto", unique = true)
    private Moto moto;

}