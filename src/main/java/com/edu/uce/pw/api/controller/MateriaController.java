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

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IEstudianteService;
import com.edu.uce.pw.api.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")

public class MateriaController {

	@Autowired
	private IMateriaService  materiaService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping
	//Nivel1:  http://localhost:8080/API/v1.0/Matricula/estudiantes
	public void guardar(@RequestBody Materia mate) {
		this.materiaService.ingresar(mate);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/
	// Nivel1:http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/1

	@PutMapping(path="/{id}")
	public void actualizar(@RequestBody Materia mate, @PathVariable Integer id) {
		mate.setId(id);
		this.materiaService.actualizar(mate);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial

	@PatchMapping(path="/{id}")
	public void actualizarParcial(@RequestBody Materia mate,@PathVariable Integer id) {
		mate.setId(id);
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
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/1
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/3
	//......

	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3


	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.materiaService.borrar(id);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/1/nuevo/prueba
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1

	@GetMapping(path = "/{id}")
	public Materia buscar(@PathVariable Integer id) {
		return this.materiaService.buscar(id);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=F%&edad=35
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=F

	@GetMapping(path="/genero")
	public List<Materia>buscarPorGenero(@RequestParam Integer numeroCreditos){
		//System.out.println("Edad:"+edad);
		List<Materia> lista=this.materiaService.BuscarPorNumeroCreditos(numeroCreditos);
		return lista;
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/3?pureba=HolaMundo
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/3?pureba=HolaMundo
	@GetMapping(path = "mixto/{id}")
	public Materia buscarMixto(@PathVariable Integer id,@RequestParam String prueba) {
		System.out.println("Dato: "+id);
		System.out.println("Dato: "+prueba);
		return this.materiaService.buscar(id);
	}
	
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/test/1
	@GetMapping(path = "test/{id}")
	public Materia test(@PathVariable Integer id,@RequestBody Materia mate) {
		System.out.println("Materia: "+mate);
		return this.materiaService.buscar(id);
	}
}
