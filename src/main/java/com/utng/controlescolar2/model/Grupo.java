/**
 * 
 */
package com.utng.controlescolar2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_GRUPO")
public class Grupo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5945356287855365089L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GRUPO")
	private Integer id;

	@Column(name = "GRUPO")
	private String grupo;

	@Column(name = "ESTATUS")
	private Integer estatus;

/*
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CICLO")
	private Ciclo ciclo;
	*/
	@Column(name = "ID_CICLO")
	private String ciclo;

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public Integer getEstatus() {
		return estatus;
	}


	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}





	public String getCiclo() {
		return ciclo;
	}


	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
