/**
 * 
 */
package com.utng.controlescolar2.model;

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
@Table (name="TBL_GRUPO_ALUMNO")
public class GrupoAlumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_GR_AL")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_GRUPO")
	private Grupo idGrupo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_ALUMNO")
	private Alumno alumno;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Grupo getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Grupo idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	} 
	
	

}
