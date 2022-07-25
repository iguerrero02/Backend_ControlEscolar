package com.utng.controlescolar2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utng.controlescolar2.model.Profesor;
import com.utng.controlescolar2.model.ProfesorMateria;
import com.utng.controlescolar2.model.ProfesorMateriaRequest;
import com.utng.controlescolar2.model.Response;

public interface ProfesorMateriaRepository extends JpaRepository<ProfesorMateria, Integer>{

	@Query("select pm from ProfesorMateria pm join fetch pm.profesor p join fetch pm.materia m")
	Response<ProfesorMateria>consultarProfesorMateria();


	
	
	
	
	
}
