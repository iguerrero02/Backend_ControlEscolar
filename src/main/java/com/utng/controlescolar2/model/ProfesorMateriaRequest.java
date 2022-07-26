package com.utng.controlescolar2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfesorMateriaRequest {
	
private Integer id;
private Integer pk_materia;
	
	private String clave;
	
	private String nombre;
	
	private Integer estatus;
	private Profesor pk_profesor;
	private Ciclo pk_ciclo;
	
}
