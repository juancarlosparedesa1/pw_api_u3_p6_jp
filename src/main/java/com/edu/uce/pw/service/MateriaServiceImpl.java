package com.edu.uce.pw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.repository.IMateriaRepository;
import com.edu.uce.pw.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository materiaRepository;
	@Override
	public Materia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.actualizar(materia);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.materiaRepository.eliminar(id);
	}

	@Override
	public void ingresar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

	@Override
	public List<Materia> BuscarPorNumeroCreditos(Integer numeroCreditos) {
		// TODO Auto-generated method stub
		return this.materiaRepository.SeleccionarPorNumeroCreditos(numeroCreditos);
	}

}
