package com.atos.concesionario.proyecto_concesionario.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.concesionario.proyecto_concesionario.Model.TipoVehiculo;
import com.atos.concesionario.proyecto_concesionario.Model.Vehiculo;

@Repository
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, String> {
	 // Método para buscar vehículos disponibles
    List<Vehiculo> findByDisponibilidadTrue();
    
    // Si se necesita más flexibilidad:
    List<Vehiculo> findByDisponibilidad(Boolean disponibilidad);
    
    // Métodos adicionales útiles
    List<Vehiculo> findByTipoVehiculoTipo(TipoVehiculo.Tipo tipo);
    
    List<Vehiculo> findByMarcaContainingIgnoreCase(String marca);
    
    List<Vehiculo> findByPrecioBetween(Double precioMin, Double precioMax);
    
    List<Vehiculo> findByEtiqueta(Vehiculo.EtiquetaAmbiental etiqueta);
}
