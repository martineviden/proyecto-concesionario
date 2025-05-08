package com.atos.concesionario.proyecto_concesionario.Model;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cocheId;

    private String marca;
    private String modelo;
    private int ano;
    private double precioPorDia;
    private boolean disponible;
    private String color;
    private int kilometraje;
    private String matricula;
    private String tipo;
    private String imagen;

    @Enumerated(EnumType.STRING)
    private Transmision transmision;

    @OneToOne(mappedBy = "coche")
    @JsonBackReference("reserva-coche")
    private Reserva reserva;

}