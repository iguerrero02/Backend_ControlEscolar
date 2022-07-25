/**
 * 
 */
package com.utng.controlescolar2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.utng.controlescolar2.model.Ciclo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "MASTER_TBL_MATERIA")
public class Materia implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_MATERIA")
	private Integer pk_materia;
	
	@Column(name="TXT_CLAVE")
	private String clave;
	
	@Column(name="DES_MATERIA")
	private String nombre;
	
	@Column(name="FK_STATUS")
	private Integer estatus;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_CICLO")
	private Ciclo ciclo;

	


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
/*
	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}
*/
	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}


	



	

	

	

	
	
}
