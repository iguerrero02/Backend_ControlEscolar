package com.utng.controlescolar2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar2.model.Materia;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.model.Status;
import com.utng.controlescolar2.repository.StatusRepository;
@Service
public class StatusService implements IStatusService {
	
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public Response<Status> consultarTodos() {
		Response<Status> response = new Response<Status>();
		List<Status> lista = statusRepository.findAll();

		if (lista.isEmpty()) {
			response.setMessage("No hay resultados");
		} else {
			response.setMessage("Consulta correcta");
		}
		response.setStatus("OK");
		response.setList(lista);
		response.setCount(lista.size());

		return response;
	}

}
