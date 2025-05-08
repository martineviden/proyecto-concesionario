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
import com.atos.concesionario.proyecto_concesionario.Model.Moto;
import com.atos.concesionario.proyecto_concesionario.Service.MotoServicio;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MotoControlador {
    

    private final MotoServicio motoServicio;

    @Autowired
    public MotoControlador(MotoServicio motoServicio) {
        this.motoServicio = motoServicio;
    }

    // Endpoints CRUD

    @GetMapping("/motos")
    public List<Moto> obtenerMotos() {
        return motoServicio.obtenerMotos();
    }

    @GetMapping("/moto/{motoId}")
    public ResponseEntity<Moto> obtenerMotoPorId(@PathVariable Long motoId) throws ResourceNotFoundException {
        return motoServicio.obtenerMotoPorId(motoId);
    }

    @PostMapping("/crear/moto")
    public Moto crearMoto(@Valid @RequestBody Moto moto) {
        return motoServicio.crearMoto(moto);
    }

    @PutMapping("/moto/{motoId}/actualizar")
    public ResponseEntity<Moto> actualizarMoto(@PathVariable Long motoId, @Valid @RequestBody Moto motoDetalles) throws ResourceNotFoundException {
        return motoServicio.actualizarMoto(motoId, motoDetalles);
    }

    @DeleteMapping("/moto/{motoId}/eliminar")
    public Map<String, Boolean> eliminarMoto(@PathVariable Long motoId) throws ResourceNotFoundException {
        return motoServicio.eliminarMoto(motoId);
    }

    // Otros endpoints

}