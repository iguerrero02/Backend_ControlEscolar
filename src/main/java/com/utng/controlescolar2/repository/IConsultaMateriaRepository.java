/**
 * 
 */
package com.utng.controlescolar2.repository;


import com.utng.controlescolar2.model.Materia;
import com.utng.controlescolar2.model.MateriaFiltroRequest;
import com.utng.controlescolar2.model.Response;

public interface IConsultaMateriaRepository {

	Response<Materia> busquedaMateria(MateriaFiltroRequest filtro);
}
