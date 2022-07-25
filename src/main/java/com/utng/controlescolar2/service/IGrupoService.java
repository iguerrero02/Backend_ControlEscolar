/**
 * 
 */
package com.utng.controlescolar2.service;

import com.utng.controlescolar2.model.Grupo;
import com.utng.controlescolar2.model.GrupoFiltroRequest;
import com.utng.controlescolar2.model.GrupoRequest;
import com.utng.controlescolar2.model.Response;

public interface IGrupoService {

	Response<Grupo> consultarTodos();

	Response<Grupo> guardar(Grupo grupo);

	Response<Grupo> buscarGrupoId(Integer idGrupo);

	Response<Integer> eliminarGrupo(Integer idGrupo);

	Response<Grupo> actualizarGrupo(Grupo grupo);

	Response<Grupo> buscarPorNombre(String grupo);

	Response<Grupo> busquedaDinamica(GrupoFiltroRequest grupo);

}
