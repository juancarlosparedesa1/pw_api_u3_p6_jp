package com.edu.uce.pw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.repository.modelo.Materia;
import com.edu.uce.pw.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")

public class MateriaController {

	@Autowired
	private IMateriaService  materiaService;

	// http://localhost:8080/API/v1.0/Matricula/materias/guardar
	@PostMapping
	//Nivel1:  http://localhost:8080/API/v1.0/Matricula/materias
	public  ResponseEntity<Materia> guardar(@RequestBody Materia mate) {
		this.materiaService.ingresar(mate);
		return ResponseEntity.status(201).body(mate);
	}

	// http://localhost:8080/API/v1.0/Matricula/materias/actualizar/
	// Nivel1:http://localhost:8080/API/v1.0/Matricula/materias/actualizar/1

	@PutMapping(path="/{id}")
	public ResponseEntity<Materia> actualizar(@RequestBody Materia mate,@PathVariable Integer id) {
		this.materiaService.actualizar(mate);
		return ResponseEntity.status(238).body(mate);
	}

	// http://localhost:8080/API/v1.0/Matricula/materias/actualizarParcial
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/materias/4

	@PatchMapping(path="/{id}")
	public ResponseEntity<Materia> actualizarParcial(@RequestBody Materia mate,@PathVariable Integer id) {
		Materia mate2 = this.materiaService.buscar(mate.getId());
		if (mate.getNombre() != null) {
			mate2.setNombre(mate.getNombre());
		}
		if (mate.getCodigo() != null) {
			mate2.setCodigo(mate.getCodigo());
		}
		if (mate.getNumeroCreditos() != null) {
			mate2.setNumeroCreditos(mate.getNumeroCreditos());
		}
		this.materiaService.actualizar(mate2);
		return ResponseEntity.status(239).body(mate2);
	}

	// http://localhost:8080/API/v1.0/Matricula/materias/borrar
	// http://localhost:8080/API/v1.0/Matricula/materias/borrar/1
	// http://localhost:8080/API/v1.0/Matricula/materias/borrar/2
	// http://localhost:8080/API/v1.0/Matricula/materias/borrar/3
	//......

	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/materias/3


	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		this.materiaService.borrar(id);
		return ResponseEntity.status(240).body("Borrado");
	}

	
	// http://localhost:8080/API/v1.0/Matricula/materias/1

	@GetMapping(path = "buscar/{id}")
	public Materia buscar(@PathVariable Integer id) {
		return this.materiaService.buscar(id);
	}
	
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/materias/buscar/creditos

	@GetMapping(path="/buscar/creditos")
	public List<Materia>buscarPorNumeroCreditos(@RequestParam Integer numeroCreditos){
		//System.out.println("Edad:"+edad);
		List<Materia> lista=this.materiaService.BuscarPorNumeroCreditos(numeroCreditos);
		return lista;
	}
	
}