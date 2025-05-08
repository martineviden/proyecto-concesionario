package com.atos.concesionario.proyecto_concesionario.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atos.concesionario.proyecto_concesionario.Exception.ResourceNotFoundException;
import com.atos.concesionario.proyecto_concesionario.Model.Moto;
import com.atos.concesionario.proyecto_concesionario.Repository.MotoRepositorio;

@Service
public class MotoServicio {
    
    @Autowired
    MotoRepositorio motoRepositorio;

    // Métodos CRUD

    public List<Moto> obtenerMotos() {
        return motoRepositorio.findAll();
    }

    public ResponseEntity<Moto> obtenerMotoPorId(Long motoId) throws ResourceNotFoundException {
        Moto moto = motoRepositorio.findById(motoId).orElseThrow(() -> new ResourceNotFoundException("Moto con id " + motoId + " no encontrada"));

        return ResponseEntity.ok().body(moto);
    }

    public Moto crearMoto(Moto moto) {
        return motoRepositorio.save(moto);
    }

    public ResponseEntity<Moto> actualizarMoto(Long motoId, Moto motoDetalles) throws ResourceNotFoundException {
        Moto moto = motoRepositorio.findById(motoId).orElseThrow(() -> new ResourceNotFoundException("Moto con id " + motoId + " no encontrada"));

        moto.setMarca(motoDetalles.getMarca());
        moto.setModelo(motoDetalles.getModelo());
        moto.setAno(motoDetalles.getAno());
        moto.setPrecioPorDia(motoDetalles.getPrecioPorDia());
        moto.setDisponible(motoDetalles.isDisponible());
        moto.setColor(motoDetalles.getColor());
        moto.setKilometraje(motoDetalles.getKilometraje());
        moto.setMatricula(motoDetalles.getMatricula());
        moto.setTipo(motoDetalles.getTipo());
        moto.setImagen(motoDetalles.getImagen());
        moto.setReserva(motoDetalles.getReserva());
        moto.setTransmision(motoDetalles.getTransmision());

        final Moto motoActualizada = motoRepositorio.save(moto);
        return ResponseEntity.ok(motoActualizada);
    }

    public Map<String, Boolean> eliminarMoto(Long motoId) throws ResourceNotFoundException {
        Moto moto = motoRepositorio.findById(motoId).orElseThrow(() -> new ResourceNotFoundException("Moto con id " + motoId + " no encontrada"));
        motoRepositorio.delete(moto);

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Moto eliminada", Boolean.TRUE);
        return respuesta;
    }

    // Otros métodos

}