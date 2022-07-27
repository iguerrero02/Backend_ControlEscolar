package com.utng.controlescolar2.service;

import com.utng.controlescolar2.model.Status;
import com.utng.controlescolar2.model.Response;

public interface IStatusService {
	Response<Status> consultarTodos();

}
