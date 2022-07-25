/**
 * 
 */
package com.utng.controlescolar2.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoFiltroRequest {

	private String idAlumno;
	private String expediente;
	
	private String nombre;
	
	private String curp;
	
	private String correo;
	
	private Ciclo ciclo;

	

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}
	
	
	
}
