/**
 * 
 */
package com.utng.controlescolar2.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MateriaRequest {
	
	private String clave;
	private String nombre;
	private Integer estatus;
	private Integer pk_ciclo;
	private Integer pk_materia;
	private Integer pk_profesor;
	
	
	public Integer getPk_ciclo() {
		return pk_ciclo;
	}
	public void setPk_ciclo(Integer pk_ciclo) {
		this.pk_ciclo = pk_ciclo;
	}
	public Integer getPk_materia() {
		return pk_materia;
	}
	public void setPk_materia(Integer pk_materia) {
		this.pk_materia = pk_materia;
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
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	
	public Integer getPk_profesor() {
		return pk_profesor;
	}
	public void setPk_profesor(Integer pk_profesor) {
		this.pk_profesor = pk_profesor;
	}
	
	
	
	



	
	
	
}
