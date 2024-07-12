package com.edu.uce.pw.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.repository.modelo.Estudiante;
import com.edu.uce.pw.service.IEstudianteService;

@RestController
@RequestMapping(path="estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;
	
	//INSERTAR C
	//construyo la URL
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping(path="/guardar")
	public void guardar() {
		Estudiante est= new Estudiante();
		est.setNombre("Juan Carlos");
		est.setApellido("Paredes");
		est.setFechaNacimiento(LocalDateTime.of(1999, 05, 10, 00, 00));
		this.estudianteService.ingresar(est);
	}
	
	//BUSCAR R
	//Construyo la URL
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	@GetMapping(path="/buscar")
	public void buscar() {
		this.estudianteService.buscar(3);
	}
	
	//ACTUALIZAR U
	//Construyo la URL
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	@PutMapping(path="/actualizar")
	public void actualizar() {
		Estudiante estu=this.estudianteService.buscar(3);
		estu.setNombre("Jose David");
		estu.setApellido("Garcia");
		estu.setFechaNacimiento(LocalDateTime.of(1999, 05, 02, 0, 0));
		this.estudianteService.actualizar(estu);
	}
	
	//ACTUALIZAR PARCIAL
	//Construyo la URL
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	@PatchMapping(path="/actualizarParcial")
	public void actualizarParcial() {
		Estudiante estu=this.estudianteService.buscar(3);
		estu.setNombre("Santiago Jose");
		this.estudianteService.actualizar(estu);
	}
	//BORRAR D
	//Construyo la URL
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	@DeleteMapping(path="/borrar")
	public void borrar() {
		this.estudianteService.borrar(1);
	}
	
	
}
