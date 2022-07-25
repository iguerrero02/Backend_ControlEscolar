package com.utng.controlescolar2.model;



public class ProfesorMateriaFiltroRequest {
	
	private Materia clave;	
	private String nombre;
	private String ciclo;
	//private String profesor;
	
	public String getNombre() {
		return nombre;
	}
	public Materia getClave() {
		return clave;
	}
	public void setClave(Materia clave) {
		this.clave = clave;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	/*
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}*/



	




}
