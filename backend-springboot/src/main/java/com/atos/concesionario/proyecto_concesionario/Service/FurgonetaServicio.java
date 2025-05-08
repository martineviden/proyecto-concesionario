package com.atos.concesionario.proyecto_concesionario.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atos.concesionario.proyecto_concesionario.Exception.ResourceNotFoundException;
import com.atos.concesionario.proyecto_concesionario.Model.Furgoneta;
import com.atos.concesionario.proyecto_concesionario.Repository.FurgonetaRepositorio;

@Service
public class FurgonetaServicio {
    

    private final FurgonetaRepositorio furgonetaRepositorio;

    @Autowired
    public FurgonetaServicio(FurgonetaRepositorio furgonetaRepositorio) {
        this.furgonetaRepositorio = furgonetaRepositorio;
    }

    // Métodos CRUD

    public List<Furgoneta> obtenerFurgonetas() {
        return furgonetaRepositorio.findAll();
    }

    public ResponseEntity<Furgoneta> obtenerFurgonetaPorId(Long furgonetaId) throws ResourceNotFoundException {
        Furgoneta furgoneta = furgonetaRepositorio.findById(furgonetaId).orElseThrow(() -> new ResourceNotFoundException("Furgoneta con id " + furgonetaId + " no encontrada"));

        return ResponseEntity.ok().body(furgoneta);
    }

    public Furgoneta crearFurgoneta(Furgoneta furgoneta) {
        return furgonetaRepositorio.save(furgoneta);
    }

    public ResponseEntity<Furgoneta> actualizarFurgoneta(Long furgonetaId, Furgoneta furgonetaDetalles) throws ResourceNotFoundException {
        Furgoneta furgoneta = furgonetaRepositorio.findById(furgonetaId).orElseThrow(() -> new ResourceNotFoundException("Furgoneta con id " + furgonetaId + " no encontrada"));

        furgoneta.setMarca(furgonetaDetalles.getMarca());
        furgoneta.setModelo(furgonetaDetalles.getModelo());
        furgoneta.setAno(furgonetaDetalles.getAno());
        furgoneta.setPrecioPorDia(furgonetaDetalles.getPrecioPorDia());
        furgoneta.setDisponible(furgonetaDetalles.isDisponible());
        furgoneta.setColor(furgonetaDetalles.getColor());
        furgoneta.setKilometraje(furgonetaDetalles.getKilometraje());
        furgoneta.setMatricula(furgonetaDetalles.getMatricula());
        furgoneta.setTipo(furgonetaDetalles.getTipo());
        furgoneta.setImagen(furgonetaDetalles.getImagen());
        furgoneta.setReserva(furgonetaDetalles.getReserva());
        furgoneta.setTransmision(furgonetaDetalles.getTransmision());

        final Furgoneta furgonetaActualizada = furgonetaRepositorio.save(furgoneta);
        return ResponseEntity.ok(furgonetaActualizada);
    }

    public Map<String, Boolean> eliminarFurgoneta(Long furgonetaId) throws ResourceNotFoundException {
        Furgoneta furgoneta = furgonetaRepositorio.findById(furgonetaId).orElseThrow(() -> new ResourceNotFoundException("Furgoneta con id " + furgonetaId + " no encontrada"));
        furgonetaRepositorio.delete(furgoneta);

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Furgoneta eliminada", Boolean.TRUE);
        return respuesta;
    }

    // Otros métodos

}