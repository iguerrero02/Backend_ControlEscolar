package com.utng.controlescolar2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar2.model.ProfesorMateria;

import com.utng.controlescolar2.model.Response;

public interface ProfesorMateriaRepository extends JpaRepository<ProfesorMateria, Integer>{

	@Query("select pm from ProfesorMateria pm join fetch pm.profesor p join fetch pm.materia m")
	Response<ProfesorMateria>consultarProfesorMateria();
/*
	@Query("select pm from ProfesorMateria pm join fetch pm.profesor p join fetch pm.materia m "
			+ "where m.nombre=?1 or m.clave=?1 or m.pk_materia=?1 or m.fk_ciclo=?1 or p.pk_profesor" )
	Response<ProfesorMateria>consultaDinamica(@Param ("dato")String dato);
*/
	
	@Query("select pm from ProfesorMateria pm join fetch pm.profesor p join fetch pm.materia m")
	List<ProfesorMateria>consultarDinamicaProfesorMateria(@Param("dato") String dato);
	
	

}
