package com.edu.uce.pw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.repository.modelo.Estudiante;
import com.edu.uce.pw.service.IEstudianteService;

@RestController
@RequestMapping(path = "estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@PostMapping
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante est) {

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_201", "Estudiante guardado");
		this.estudianteService.ingresar(est);
		return new ResponseEntity<>(est, cabeceras, 201);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mesaje_238", "El estudiante fue actualizado");
		est.setId(id);
		this.estudianteService.actualizar(est);
		// return ResponseEntity.status(238).body(est);
		return new ResponseEntity<>(est, cabeceras, 238);
	}

	@PatchMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		Estudiante est2 = this.estudianteService.buscar(est.getId());
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mesaje_239", "Estudiante actualizado parcialmente");

		if (est.getNombre() != null) {
			est2.setNombre(est.getNombre());
		}

		if (est.getApellido() != null) {
			est2.setApellido(est.getApellido());
		}

		if (est.getFechaNacimiento() != null) {
			est2.setFechaNacimiento(est.getFechaNacimiento());
		}

		this.estudianteService.actualizar(est2);

		// return ResponseEntity.status(239).body(est2);
		return new ResponseEntity<>(est2, cabeceras, 239);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_240", "La materia fue borrada");
		this.estudianteService.borrar(id);
		// return ResponseEntity.status(240).body("Borrado");
		return new ResponseEntity<>("Estudiante borrado", cabeceras, 236);
	}

	@GetMapping(path = "/{id}")

	public ResponseEntity<Estudiante> buscarPorId(@PathVariable Integer id) {
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "Estudiante escontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id), cabeceras, 236);
	}

}
