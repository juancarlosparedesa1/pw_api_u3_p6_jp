package com.edu.uce.pw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.repository.IEstudianteRepository;
import com.edu.uce.pw.repository.modelo.Estudiante;
import com.edu.uce.pw.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void ingresar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	// convertidor recibe un Estudiante y retorna un EstudainteTO
	public EstudianteTO convertir(Estudiante estu) {
		EstudianteTO estTo = new EstudianteTO();
		estTo.setId(estu.getId());
		estTo.setNombre(estu.getNombre());
		estTo.setApellido(estu.getApellido());
		estTo.setFechaNacimiento(estu.getFechaNacimiento());
		return estTo;
	}

	@Override
	public EstudianteTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		Estudiante est = this.estudianteRepository.seleccionar(id);
		return this.convertir(est);
	}

	@Override
	public List<EstudianteTO> buscarTodosEstudiantesTO() {
		// TODO Auto-generated method stub
		List<Estudiante> estudiantes = this.estudianteRepository.seleccionarTodosEstudiantes();
		List<EstudianteTO> estudiantesTO = new ArrayList<>();
		for (Estudiante estudiante : estudiantes) {
			EstudianteTO estudianteTO = this.convertir(estudiante);
			estudiantesTO.add(estudianteTO);
		}
		return estudiantesTO;
	}
}
