/**
 * 
 */
package com.utng.controlescolar2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CicloFiltroRequest {
	private String clave;
	private String nombre;
	private String year;
	/*
	private Date year;
	private Date year2;
	*/
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	
}
