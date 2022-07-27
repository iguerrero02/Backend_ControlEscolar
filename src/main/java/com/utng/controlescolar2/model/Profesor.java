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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "MASTER_TBL_PROFESOR")
public class Profesor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_PROFESOR")
	private Integer idProfesor;
	
	@Column(name="TXT_CLAVE")
	private String clave;
	
	@Column(name="TXT_NOMBRE")
	private String nombre;
	
	@Column(name="TXT_APE_PATERNO")
	private String apePaterno;
	
	@Column(name="TXT_APE_MATERNO")
	private String apeMaterno;
	
	@Column(name="TXT_CORREO")
	private String correo;






	
	
}
