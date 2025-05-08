package com.atos.concesionario.proyecto_concesionario.Model;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private int año;
    private double precioPorHora;
    private boolean disponibilidad;
    private String color;
    private int kilometraje;
    private String matricula;
    private String tipo;
    private String imagen;

    @OneToOne(mappedBy = "moto")
    private Reserva reserva;
}