package com.edu.uce.pw.service;

import java.util.List;

import com.edu.uce.pw.repository.modelo.Materia;

public interface IMateriaService {
	// CRUD
		public Materia buscar(Integer id);

		public void actualizar(Materia materia);

		public void borrar(Integer id);

		public void ingresar(Materia mnateria	);
		 List<Materia>BuscarPorNumeroCreditos(Integer numeroCreditos);


}
