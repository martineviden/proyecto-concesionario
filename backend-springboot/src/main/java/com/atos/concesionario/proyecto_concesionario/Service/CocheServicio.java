package com.atos.concesionario.proyecto_concesionario.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atos.concesionario.proyecto_concesionario.Exception.ResourceNotFoundException;
import com.atos.concesionario.proyecto_concesionario.Model.Coche;
import com.atos.concesionario.proyecto_concesionario.Repository.CocheRepositorio;

@Service
public class CocheServicio {

    private final CocheRepositorio cocheRepositorio;

    @Autowired
    public CocheServicio(CocheRepositorio cocheRepositorio) {
        this.cocheRepositorio = cocheRepositorio;
    }

    // Métodos CRUD

    public List<Coche> obtenerCoches() {
        return cocheRepositorio.findAll();
    }

    public ResponseEntity<Coche> obtenerCochePorId(Long cocheId) throws ResourceNotFoundException {
        Coche coche = cocheRepositorio.findById(cocheId).orElseThrow(() -> new ResourceNotFoundException("Coche con id " + cocheId + " no encontrado"));

        return ResponseEntity.ok().body(coche);
    }

    public Coche crearCoche(Coche coche) {
        return cocheRepositorio.save(coche);
    }

    public ResponseEntity<Coche> actualizarCoche(Long cocheId, Coche cocheDetalles) throws ResourceNotFoundException {
        Coche coche = cocheRepositorio.findById(cocheId).orElseThrow(() -> new ResourceNotFoundException("Coche con id " + cocheId + " no encontrado"));

        coche.setMarca(cocheDetalles.getMarca());
        coche.setModelo(cocheDetalles.getModelo());
        coche.setAno(cocheDetalles.getAno());
        coche.setPrecioPorDia(cocheDetalles.getPrecioPorDia());
        coche.setDisponible(cocheDetalles.isDisponible());
        coche.setColor(cocheDetalles.getColor());
        coche.setKilometraje(cocheDetalles.getKilometraje());
        coche.setMatricula(cocheDetalles.getMatricula());
        coche.setTipo(cocheDetalles.getTipo());
        coche.setImagen(cocheDetalles.getImagen());
        coche.setReserva(cocheDetalles.getReserva());
        coche.setTransmision(cocheDetalles.getTransmision());

        final Coche cocheActualizado = cocheRepositorio.save(coche);
        return ResponseEntity.ok(cocheActualizado);
    }

    public Map<String, Boolean> eliminarCoche(Long cocheId) throws ResourceNotFoundException {
        Coche coche = cocheRepositorio.findById(cocheId).orElseThrow(() -> new ResourceNotFoundException("Coche con id " + cocheId + " no encontrado"));
        cocheRepositorio.delete(coche);

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Coche eliminado", Boolean.TRUE);
        return respuesta;
    }

    // Otros métodos

}
