package com.utng.controlescolar2.service;


import com.utng.controlescolar2.model.Grupo;
import com.utng.controlescolar2.model.GrupoFiltroRequest;
import com.utng.controlescolar2.model.Materia;
import com.utng.controlescolar2.model.Profesor;
import com.utng.controlescolar2.model.ProfesorMateria;
import com.utng.controlescolar2.model.ProfesorMateriaFiltroRequest;
import com.utng.controlescolar2.model.ProfesorMateriaRequest;
import com.utng.controlescolar2.model.Response;

public interface IProfesorMateriaService {
	Response<ProfesorMateria> consultarTodos();
	
	Response<ProfesorMateria>consultaProfesorMateria();
	
	Response<ProfesorMateria>busquedaDinamica(ProfesorMateriaFiltroRequest profesorMateria);
	
	Response<ProfesorMateria> actualizar(ProfesorMateria Profesormateria);
	
	Response<ProfesorMateria> guardar(ProfesorMateria Profesormateria);

	Response<Profesor>consultaProfesor();

	Response<Integer> eliminarMateriaProfe(Integer idPrMt);

	
	
}
