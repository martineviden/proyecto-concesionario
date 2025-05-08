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
import com.atos.concesionario.proyecto_concesionario.Model.Coche;
import com.atos.concesionario.proyecto_concesionario.Service.CocheServicio;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CocheControlador {
    
    @Autowired
    CocheServicio cocheServicio;

    // Endpoints CRUD

    @GetMapping("/coches")
    public List<Coche> obtenerCoches() {
        return cocheServicio.obtenerCoches();
    }

    @GetMapping("/coche/{cocheId}")
    public ResponseEntity<Coche> obtenerCochePorId(@PathVariable Long cocheId) throws ResourceNotFoundException {
        return cocheServicio.obtenerCochePorId(cocheId);
    }

    @PostMapping("/crear/coche")
    public Coche crearCoche(@Valid @RequestBody Coche coche) {
        return cocheServicio.crearCoche(coche);
    }

    @PutMapping("/coche/{cocheId}/actualizar")
    public ResponseEntity<Coche> actualizarCoche(@PathVariable Long cocheId, @Valid @RequestBody Coche cocheDetalles) throws ResourceNotFoundException {
        return cocheServicio.actualizarCoche(cocheId, cocheDetalles);
    }

    @DeleteMapping("/coche/{cocheId}/eliminar")
    public Map<String, Boolean> eliminarCoche(@PathVariable Long cocheId) throws ResourceNotFoundException {
        return cocheServicio.eliminarCoche(cocheId);
    }

    // Otros endpoints

}