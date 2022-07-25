/**
 * 
 */
package com.utng.controlescolar2.repository;

import com.utng.controlescolar2.model.Ciclo;
import com.utng.controlescolar2.model.CicloFiltroRequest;
import com.utng.controlescolar2.model.Response;

public interface IConsultaCicloRepository {
	Response<Ciclo> busquedaCiclo(CicloFiltroRequest filtro);
}
