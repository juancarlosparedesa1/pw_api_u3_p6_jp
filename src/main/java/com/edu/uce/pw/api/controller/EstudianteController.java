package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;

@RestController
@RequestMapping(path = "/estudiantes")

public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping
	//Nivel1:  http://localhost:8080/API/v1.0/Matricula/estudiantes
	public void guardar(@RequestBody Estudiante est) {
		this.estudianteService.ingresar(est);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/
	// Nivel1:http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/1

	@PutMapping(path="/{id}")
	public void actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		this.estudianteService.actualizar(est);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial

	@PatchMapping(path="/{id}")
	public void actualizarParcial(@RequestBody Estudiante est,@PathVariable Integer id) {
		est.setId(id);
		Estudiante est2 = this.estudianteService.buscar(est.getId());
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
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/1
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/3
	//......

	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3


	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/1/nuevo/prueba
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1

	@GetMapping(path = "/{id}")
	public Estudiante buscar(@PathVariable Integer id) {
		return this.estudianteService.buscar(id);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=F%&edad=35
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=F

	@GetMapping(path="/genero")
	public List<Estudiante>buscarPorGenero(@RequestParam String genero){
		//System.out.println("Edad:"+edad);
		List<Estudiante> lista=this.estudianteService.BuscarPorGenero(genero);
		return lista;
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/3?pureba=HolaMundo
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/3?pureba=HolaMundo
	@GetMapping(path = "mixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id,@RequestParam String prueba) {
		System.out.println("Dato: "+id);
		System.out.println("Dato: "+prueba);
		return this.estudianteService.buscar(id);
	}
	
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/test/1
	@GetMapping(path = "test/{id}")
	public Estudiante test(@PathVariable Integer id,@RequestBody Estudiante est) {
		System.out.println("Estudiante: "+est);
		return this.estudianteService.buscar(id);
	}
}
