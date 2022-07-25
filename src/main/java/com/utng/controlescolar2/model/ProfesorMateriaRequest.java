package com.utng.controlescolar2.model;

public class ProfesorMateriaRequest {
	
private Integer id;
private Integer idMateria;
	
	private String clave;
	
	private String nombre;
	
	private Integer estatus;
	private Integer pk_profesor;
	private Integer pk_ciclo;
	
	
	
	
	public Integer getidMateria() {
		return idMateria;
	}
	public void setidMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getPk_ciclo() {
		return pk_ciclo;
	}
	public void setPk_ciclo(Integer pk_ciclo) {
		this.pk_ciclo = pk_ciclo;
	}
	
	
	

	

	
	
	
}
