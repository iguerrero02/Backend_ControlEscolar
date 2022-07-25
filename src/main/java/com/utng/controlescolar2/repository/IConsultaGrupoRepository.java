package com.utng.controlescolar2.repository;

import com.utng.controlescolar2.model.Grupo;
import com.utng.controlescolar2.model.GrupoFiltroRequest;
import com.utng.controlescolar2.model.Response;

public interface IConsultaGrupoRepository {
	Response<Grupo> busquedaGrupo(GrupoFiltroRequest filtro);
}
