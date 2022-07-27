package com.utng.controlescolar2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.model.Status;
import com.utng.controlescolar2.service.IStatusService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/status")
public class StatusController {
	@Autowired
	private IStatusService statusService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Status>> consultarTodos() {
		Response<Status> response = statusService.consultarTodos();
		return new ResponseEntity<Response<Status>>(response, HttpStatus.OK);
	}
}
