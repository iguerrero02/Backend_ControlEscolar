/**
 * 
 */
package com.utng.controlescolar2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MateriaFiltroRequest {

	private String clave;
	private String nombre;
	private String pk_ciclo;
	private String pk_profesor;

	
	
	public String getPk_ciclo() {
		return pk_ciclo;
	}

	public void setPk_ciclo(String pk_ciclo) {
		this.pk_ciclo = pk_ciclo;
	}

	public String getPk_profesor() {
		return pk_profesor;
	}

	public void setPk_profesor(String pk_profesor) {
		this.pk_profesor = pk_profesor;
	}

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


	

	
	
	
}
