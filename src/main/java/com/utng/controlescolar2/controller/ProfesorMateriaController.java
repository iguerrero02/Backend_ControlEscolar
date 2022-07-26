package com.utng.controlescolar2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar2.model.Materia;
import com.utng.controlescolar2.model.MateriaFiltroRequest;
import com.utng.controlescolar2.model.Profesor;
import com.utng.controlescolar2.model.ProfesorMateria;
import com.utng.controlescolar2.model.ProfesorMateriaFiltroRequest;
import com.utng.controlescolar2.model.ProfesorMateriaRequest;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.service.IProfesorMateriaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profesorMateria")
public class ProfesorMateriaController {
	
	@Autowired
	private IProfesorMateriaService profesorMateriaService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<ProfesorMateria>> consultarTodos() {
		Response<ProfesorMateria> response = profesorMateriaService.consultarTodos();
		return new ResponseEntity<Response<ProfesorMateria>>(response, HttpStatus.OK);
	}
	@GetMapping(path = "/consultarProfesorMateria", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<ProfesorMateria>>consultarProfesorMateria() {
		Response<ProfesorMateria> response = profesorMateriaService.consultaProfesorMateria();
		return new ResponseEntity<Response<ProfesorMateria>>(response, HttpStatus.OK);
	}
	@PostMapping(path = "/buscarMateriaProfesorDinamica", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<ProfesorMateria>> busquedaDinamica(
			@RequestBody ProfesorMateriaFiltroRequest filtro) {
		Response<ProfesorMateria> response = profesorMateriaService.busquedaDinamica(filtro);
		return new ResponseEntity<Response<ProfesorMateria>>(response, HttpStatus.OK);
	}
	@PutMapping(path = "/actMateriaProfe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<ProfesorMateria>> actualizarMateria(@RequestBody ProfesorMateria Profesormateria) {
		Response<ProfesorMateria> response = profesorMateriaService.actualizar(Profesormateria);
		return new ResponseEntity<Response<ProfesorMateria>>(response, HttpStatus.OK);
	}
	@GetMapping(path = "/consultarTodosProfe", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Profesor>> consultarTodos1() {
		Response<Profesor> response = profesorMateriaService.consultaProfesor();
		return new ResponseEntity<Response<Profesor>>(response, HttpStatus.OK);
	}
	@PostMapping(path = "/guardarMateriaProfe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<ProfesorMateria>> guardarMateria(@RequestBody ProfesorMateria Profesormateria) {
		Response<ProfesorMateria> response = profesorMateriaService.guardar(Profesormateria);
		return new ResponseEntity<Response<ProfesorMateria>>(response, HttpStatus.OK);
	}
}
