package com.atos.concesionario.proyecto_concesionario.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.concesionario.proyecto_concesionario.Exception.ResourceNotFoundException;
import com.atos.concesionario.proyecto_concesionario.Model.Furgoneta;
import com.atos.concesionario.proyecto_concesionario.Service.FurgonetaServicio;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class FurgonetaControlador {
    
    @Autowired
    FurgonetaServicio furgonetaServicio;

    // Endpoints CRUD

    @GetMapping("/furgonetas")
    public List<Furgoneta> obtenerFurgonetas() {
        return furgonetaServicio.obtenerFurgonetas();
    }

    @GetMapping("/furgoneta/{furgonetaId}")
    public ResponseEntity<Furgoneta> obtenerFurgonetaPorId(@PathVariable Long furgonetaId) throws ResourceNotFoundException {
        return furgonetaServicio.obtenerFurgonetaPorId(furgonetaId);
    }

    @PostMapping("/crear/furgoneta")
    public Furgoneta crearFurgoneta(@Valid @RequestBody Furgoneta furgoneta) {
        return furgonetaServicio.crearFurgoneta(furgoneta);
    }

    @PutMapping("/furgoneta/{furgonetaId}/actualizar")
    public ResponseEntity<Furgoneta> actualizarFurgoneta(@PathVariable Long furgonetaId, @Valid @RequestBody Furgoneta furgonetaDetalles) throws ResourceNotFoundException {
        return furgonetaServicio.actualizarFurgoneta(furgonetaId, furgonetaDetalles);
    }

    @DeleteMapping("/furgoneta/{furgonetaId}/eliminar")
    public Map<String, Boolean> eliminarFurgoneta(@PathVariable Long furgonetaId) throws ResourceNotFoundException {
        return furgonetaServicio.eliminarFurgoneta(furgonetaId);
    }

    // Otros endpoints

}