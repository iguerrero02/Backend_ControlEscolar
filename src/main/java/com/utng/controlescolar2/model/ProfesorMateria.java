package com.utng.controlescolar2.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="REL_TBL_PROFESOR_MATERIA")
public class ProfesorMateria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_PR_MT")
	private Integer pk_Pr_Mt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_PROFESOR")
	private Profesor profesor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_MATERIA")
	private Materia materia;


	
	
	


	
	
	
	
	


	
/*
	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}*/
	
	
}
