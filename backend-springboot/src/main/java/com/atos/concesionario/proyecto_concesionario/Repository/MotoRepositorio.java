package com.atos.concesionario.proyecto_concesionario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.concesionario.proyecto_concesionario.Model.Moto;

@Repository
public interface MotoRepositorio extends JpaRepository<Moto, Long> {
    
}
