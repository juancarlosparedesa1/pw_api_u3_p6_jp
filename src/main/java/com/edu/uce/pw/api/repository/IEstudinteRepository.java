package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

public interface IEstudinteRepository {

	// CRUD
	 Estudiante seleccionar(Integer id);

	 void actualizar(Estudiante estudiante);

	 void eliminar(Integer id);

	 void insertar(Estudiante estudiante);
	 
	 List<Estudiante>SeleccionarPorGenero(String genero);
}
