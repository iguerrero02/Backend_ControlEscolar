package com.utng.controlescolar2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.utng.controlescolar2.model.Materia;
import com.utng.controlescolar2.model.Profesor;
import com.utng.controlescolar2.model.ProfesorMateria;
import com.utng.controlescolar2.model.ProfesorMateriaFiltroRequest;
import com.utng.controlescolar2.model.ProfesorMateriaRequest;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.repository.ConsultaProfesorMateriaRepository;
import com.utng.controlescolar2.repository.ProfesorMateriaRepository;
import com.utng.controlescolar2.repository.ProfesorRepository;
@SpringBootApplication(scanBasePackages = "com.spring.beans")
@Service
public class ProfesorMateriaService implements IProfesorMateriaService{
@Autowired
private ProfesorMateriaRepository profesorMateriaRepository;
@Autowired
private ProfesorRepository profesorRepository;

@Autowired (required=false)
private ConsultaProfesorMateriaRepository consultaProfesorMateriaRepository;
	@Override
	public Response<ProfesorMateria> consultarTodos() {
		
		Response<ProfesorMateria> response = new Response<ProfesorMateria>();
		List<ProfesorMateria> lista = profesorMateriaRepository.findAll();

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
	@Override
	public Response<ProfesorMateria> consultaProfesorMateria() {
		
		Response<ProfesorMateria> response = new Response<ProfesorMateria>();
		List<ProfesorMateria> lista = profesorMateriaRepository.findAll();

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
	@Override
	public Response<ProfesorMateria> busquedaDinamica(ProfesorMateriaFiltroRequest profesorMateria) {
		Response<ProfesorMateria> response = new Response<ProfesorMateria>();
		response=consultaProfesorMateriaRepository.busquedaProfesorMateria(profesorMateria);
		return response;
	}
	
	@Override
	public Response<ProfesorMateria> actualizar(ProfesorMateria profesorMateria) {
		Response<ProfesorMateria> response = new Response<ProfesorMateria>();
		ProfesorMateria materiaNuevo=profesorMateriaRepository.save(profesorMateria);
		response.setStatus("OK");
		response.setMessage("Guardado Correctamente");
		response.setData(materiaNuevo);
		return response;

		/*Response<ProfesorMateria> response = new Response<ProfesorMateria>();
		ProfesorMateria materiaNuevo=profesorMateriaRepository.save(Profesormateria);
		response.setStatus("OK");
		response.setMessage("Guardado Correctamente");
		response.setData(materiaNuevo);
		return response;
*/
	}
	@Override
	public Response<Profesor> consultaProfesor() {
		Response<Profesor> response = new Response<Profesor>();
		List<Profesor> lista = profesorRepository.findAll();

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
	@Override
	public Response<ProfesorMateria> guardar(ProfesorMateria Profesormateria) {
		Response<ProfesorMateria> response = new Response<ProfesorMateria>();
		ProfesorMateria materiaNuevo=profesorMateriaRepository.save(Profesormateria);
		response.setStatus("OK");
		response.setMessage("Guardado Correctamente");
		response.setData(materiaNuevo);
		return response;
	
	}
}

