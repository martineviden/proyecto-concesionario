package com.atos.concesionario.proyecto_concesionario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.concesionario.proyecto_concesionario.Model.Resena;

@Repository
public interface ResenaRepositorio extends JpaRepository<Resena, Long> {
    
}
