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

	public Integer getPk_Pr_Mt() {
		return pk_Pr_Mt;
	}

	public void setPk_Pr_Mt(Integer pk_Pr_Mt) {
		this.pk_Pr_Mt = pk_Pr_Mt;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	

	
	
	
	
	
	


	
/*
	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}*/
	
	
}
