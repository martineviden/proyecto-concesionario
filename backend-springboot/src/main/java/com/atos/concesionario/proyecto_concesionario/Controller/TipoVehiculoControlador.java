package com.atos.concesionario.proyecto_concesionario.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atos.concesionario.proyecto_concesionario.Exception.ResourceNotFoundException;
import com.atos.concesionario.proyecto_concesionario.Model.TipoVehiculo;
import com.atos.concesionario.proyecto_concesionario.Service.TipoVehiculoServicio;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tipos-vehiculo")
public class TipoVehiculoControlador {
	private final TipoVehiculoServicio tipoVehiculoServicio;

	@Autowired
	public TipoVehiculoControlador(TipoVehiculoServicio tipoVehiculoServicio) {
		this.tipoVehiculoServicio = tipoVehiculoServicio;
	}

	@GetMapping
	public List<TipoVehiculo> obtenerTodosTiposVehiculos() {
		return tipoVehiculoServicio.obtenerTodosTiposVehiculos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoVehiculo> obtenerTipoVehiculoPorId(@PathVariable Long id)
			throws ResourceNotFoundException {
		return tipoVehiculoServicio.obtenerTipoVehiculoPorId(id);
	}

	@PostMapping
	public TipoVehiculo crearTipoVehiculo(@Valid @RequestBody TipoVehiculo tipoVehiculo) {
		return tipoVehiculoServicio.crearTipoVehiculo(tipoVehiculo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoVehiculo> actualizarTipoVehiculo(@PathVariable Long id,
			@Valid @RequestBody TipoVehiculo tipoVehiculoDetalles) throws ResourceNotFoundException {
		return tipoVehiculoServicio.actualizarTipoVehiculo(id, tipoVehiculoDetalles);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> eliminarTipoVehiculo(@PathVariable Long id) throws ResourceNotFoundException {
		return tipoVehiculoServicio.eliminarTipoVehiculo(id);
	}
}
