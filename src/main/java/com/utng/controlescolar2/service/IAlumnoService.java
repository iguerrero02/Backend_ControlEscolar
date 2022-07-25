/**
 * 
 */
package com.utng.controlescolar2.service;


import com.utng.controlescolar2.model.Alumno;
import com.utng.controlescolar2.model.AlumnoFiltroRequest;
import com.utng.controlescolar2.model.AlumnoRequest;
import com.utng.controlescolar2.model.Response;

public interface IAlumnoService {
	
	Response<Alumno> consultarTodos();

	Response<Alumno> guardar(Alumno alumno);

	Response<Alumno> buscarAlumnoId(Integer idAlumno);

	Response<Integer> eliminarAlumno(Integer idAlumno);

	Response<Alumno> actualizarAlumno(Alumno alumno);

	//Response<Alumno> buscarPorNombre(String grupo);
	
	Response<Alumno> buscarAlumnoDinamica(AlumnoFiltroRequest alumno);

}
