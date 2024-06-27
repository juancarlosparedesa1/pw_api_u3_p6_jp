package com.edu.uce.pw.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudinteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudinteRepository estudinteRepository;
	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudinteRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudinteRepository.actualizar(estudiante);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudinteRepository.eliminar(id);
	}

	@Override
	public void ingresar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudinteRepository.insertar(estudiante);
	}

}
