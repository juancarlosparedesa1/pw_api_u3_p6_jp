package com.edu.uce.pw.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class EstudianteTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1878888135939280078L;
	private Integer id;
	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimiento;

	private List<MateriaTO> materias;

	// set and get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<MateriaTO> getMaterias() {
		return materias;
	}

	public void setMaterias(List<MateriaTO> materias) {
		this.materias = materias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
