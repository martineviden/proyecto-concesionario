package com.atos.concesionario.proyecto_concesionario.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atos.concesionario.proyecto_concesionario.Exception.ResourceNotFoundException;
import com.atos.concesionario.proyecto_concesionario.Model.TipoVehiculo;
import com.atos.concesionario.proyecto_concesionario.Model.Vehiculo;
import com.atos.concesionario.proyecto_concesionario.Repository.VehiculoRepositorio;

@Service
public class VehiculoServicio {

    private final VehiculoRepositorio vehiculoRepositorio;

    @Autowired
    public VehiculoServicio(VehiculoRepositorio vehiculoRepositorio) {
        this.vehiculoRepositorio = vehiculoRepositorio;
    }

    public List<Vehiculo> obtenerTodosVehiculos() {
        return vehiculoRepositorio.findAll();
    }

    public List<Vehiculo> obtenerVehiculosDisponibles() {
        return vehiculoRepositorio.findByDisponibilidadTrue();
    }

    public ResponseEntity<Vehiculo> obtenerVehiculoPorMatricula(String matricula) throws ResourceNotFoundException {
        Vehiculo vehiculo = vehiculoRepositorio.findById(matricula)
            .orElseThrow(() -> new ResourceNotFoundException("Vehículo con matrícula " + matricula + " no encontrado"));
        return ResponseEntity.ok().body(vehiculo);
    }

    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        return vehiculoRepositorio.save(vehiculo);
    }

    public ResponseEntity<Vehiculo> actualizarVehiculo(String matricula, Vehiculo detallesVehiculo) 
        throws ResourceNotFoundException {
        Vehiculo vehiculo = vehiculoRepositorio.findById(matricula)
            .orElseThrow(() -> new ResourceNotFoundException("Vehículo con matrícula " + matricula + " no encontrado"));

        vehiculo.setTipoVehiculo(detallesVehiculo.getTipoVehiculo());
        vehiculo.setColor(detallesVehiculo.getColor());
        vehiculo.setKilometraje(detallesVehiculo.getKilometraje());
        vehiculo.setDisponibilidad(detallesVehiculo.getDisponibilidad());
        vehiculo.setCombustible(detallesVehiculo.getCombustible());
        vehiculo.setEtiqueta(detallesVehiculo.getEtiqueta());
        vehiculo.setAutonomia(detallesVehiculo.getAutonomia());
        vehiculo.setPuertas(detallesVehiculo.getPuertas());
        vehiculo.setAireAcondicionado(detallesVehiculo.getAireAcondicionado());
        vehiculo.setPlazas(detallesVehiculo.getPlazas());
        vehiculo.setTransmision(detallesVehiculo.getTransmision());

        final Vehiculo vehiculoActualizado = vehiculoRepositorio.save(vehiculo);
        return ResponseEntity.ok(vehiculoActualizado);
    }

    public Map<String, Boolean> eliminarVehiculo(String matricula) throws ResourceNotFoundException {
        Vehiculo vehiculo = vehiculoRepositorio.findById(matricula)
            .orElseThrow(() -> new ResourceNotFoundException("Vehículo con matrícula " + matricula + " no encontrado"));
        
        vehiculoRepositorio.delete(vehiculo);

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Vehículo eliminado", Boolean.TRUE);
        return respuesta;
    }

    public List<Vehiculo> obtenerVehiculosPorTipo(TipoVehiculo.Tipo tipo) {
        return vehiculoRepositorio.findByTipoVehiculoTipo(tipo);
    }

    public List<Vehiculo> buscarVehiculosPorMarca(String marca) {
        return vehiculoRepositorio.findByMarcaContainingIgnoreCase(marca);
    }
    
    // Métodos adicionales podrían incluir:
    // - Buscar vehículos por rango de precio
    // - Actualizar disponibilidad
}