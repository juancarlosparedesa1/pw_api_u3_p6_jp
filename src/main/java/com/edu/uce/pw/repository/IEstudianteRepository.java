package com.edu.uce.pw.repository;

import com.edu.uce.pw.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	//crud
	public void insertar(Estudiante estudiante);
	public Estudiante seleccionar(Integer id);
	public void actualizar(Estudiante estudiante);
	public void eliminar(Integer id);

}
