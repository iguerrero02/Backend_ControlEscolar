package com.utng.controlescolar2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfesorMateriaFiltroRequest {
	
	private String clave;	
	private String nombre;
	private String ciclo;
	private String profesor;

}
