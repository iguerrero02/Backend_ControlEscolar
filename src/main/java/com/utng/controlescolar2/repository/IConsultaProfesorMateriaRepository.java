package com.utng.controlescolar2.repository;

import com.utng.controlescolar2.model.ProfesorMateria;
import com.utng.controlescolar2.model.ProfesorMateriaFiltroRequest;
import com.utng.controlescolar2.model.Response;

public interface IConsultaProfesorMateriaRepository {

	Response<ProfesorMateria>busquedaProfesorMateria(ProfesorMateriaFiltroRequest filtro);
	
	
}
