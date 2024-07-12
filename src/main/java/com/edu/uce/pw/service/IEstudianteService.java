package com.edu.uce.pw.service;

import com.edu.uce.pw.repository.modelo.Estudiante;

public interface IEstudianteService {
	public void ingresar(Estudiante estudiante);

	public Estudiante buscar(Integer id);

	public void actualizar(Estudiante estudiante);

	public void borrar(Integer id);

}
