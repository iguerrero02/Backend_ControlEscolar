/**
 * 
 */
package com.utng.controlescolar2.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
@Entity
@Table (name="MASTER_TBL_CICLO_ESCOLAR")
public class Ciclo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7050556843575522943L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_CICLO")
	private Integer idCiclo;
	
	@Column(name="TXT_CLAVE")
	private String clave;
	
	@Column(name="TXT_DESC_CICLO")
	private String nombre;
	
	
	@Column(name="FK_STATUS")
	private Integer estatus;
	
	
	@Column(name="FK_PERIODO")
	private Integer periodo;
	
	@Column(name="DAT_FECHA_INICIO")
	private Date fechainicio;
	
	@Column(name="DAT_FECHA_FIN")
	private Date fechafin;

	

	

	
	

	

	
}
