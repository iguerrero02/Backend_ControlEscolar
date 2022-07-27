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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_MATERIA")
	private Integer idMateria;
	
	@Column(name="TXT_CLAVE")
	private String clave;
	
	@Column(name="DES_MATERIA")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_STATUS")
	private Status status;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_CICLO")
	public Ciclo ciclo;

	
	
	public Profesor profesor;
	
	/*
	public Materia(String Ciclo) {
		Ciclo=Ciclo;
		
		
	}
	*/



	



	

	

	

	
	
}
