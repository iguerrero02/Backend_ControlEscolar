/**
 * 
 */
package com.utng.controlescolar2.repository;

import com.utng.controlescolar2.model.Alumno;
import com.utng.controlescolar2.model.AlumnoFiltroRequest;
import com.utng.controlescolar2.model.Response;

public interface IConsultaAlumnoRepository {
	Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro);
}
