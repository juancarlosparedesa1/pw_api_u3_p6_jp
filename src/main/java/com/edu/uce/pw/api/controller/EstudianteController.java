package com.edu.uce.pw.api.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;

@RestController 

@RequestMapping(path="/estudiantes")

public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar 
	@PostMapping(path="/guardar")
	public void guardar() {
		Estudiante est= new Estudiante();
		est.setNombre("Juan");
		est.setApellido("Paredes");
		est.setFechaNacimiento(LocalDateTime.of(1999, 2, 7, 0, 0));
		this.estudianteService.ingresar(est);
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	@PutMapping(path="/actualizar")
	public void actualizar() {
		Estudiante est=this.estudianteService.buscar(1);
		est.setNombre("Jose David");
		est.setApellido("Paredes");
		est.setFechaNacimiento(LocalDateTime.of(2022, 7, 5, 0, 0));
		this.estudianteService.actualizar(est);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial 
	@PatchMapping(path="/actualizarParcial")
	public void actualizarParcial() {
		Estudiante est=this.estudianteService.buscar(1);
		est.setNombre("Edison");
		this.estudianteService.actualizar(est);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	@DeleteMapping(path="/borrar")
	public void borrar() {
		this.estudianteService.borrar(1);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar 
	@GetMapping(path="/buscar")
	public Estudiante buscar() {
		return this.estudianteService.buscar(1);
		
	}
}
