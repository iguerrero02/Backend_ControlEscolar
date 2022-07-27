package com.utng.controlescolar2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfesorMateriaRequest {
	
private Integer id;
private Integer idMateria;
	
	private String clave;
	
	private String nombre;
	
	private Integer estatus;
	private Profesor profesor;
	private Ciclo ciclo;
	
}
