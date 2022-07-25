/**
 * 
 */
package com.utng.controlescolar2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.utng.controlescolar2.model.Ciclo;
import com.utng.controlescolar2.model.Grupo;
import com.utng.controlescolar2.model.GrupoFiltroRequest;
import com.utng.controlescolar2.model.GrupoRequest;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.repository.CicloRepository;
import com.utng.controlescolar2.repository.ConsultaCicloRepository;
import com.utng.controlescolar2.repository.ConsultaGrupoRepository;
import com.utng.controlescolar2.repository.GrupoRepository;
@SpringBootApplication(scanBasePackages = "com.spring.beans")
@Service
public class GrupoService implements IGrupoService {

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired(required = false) 
	private CicloRepository cicloRepository;
	@Autowired(required = false) 
	private ConsultaGrupoRepository consultaGrupoRepository;


	@Override
	public Response<Grupo> consultarTodos() {
		Response<Grupo> response = new Response<Grupo>();
		List<Grupo> lista = grupoRepository.findAll();

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
	public Response<Grupo> guardar(Grupo grupo) {
		Response<Grupo> response = new Response<Grupo>();
		Grupo grupoNuevo=grupoRepository.save(grupo);
		response.setStatus("OK");
		response.setMessage("Alumno no existe");
		response.setData(grupoNuevo);
/*
		Optional<Ciclo> optional = cicloRepository.findById(grupo.getIdCiclo());
		Optional<Grupo> optionalG = grupoRepository.findById(grupo.getId());
		Ciclo ciclo = null;
		Grupo grupo1 = null;
		Grupo grupo2 = null;

		if (optionalG.isPresent()) {
			if (optional.isPresent()) {
				ciclo = optional.get();
				grupo1 = new Grupo();
				grupo1.setEstatus(grupo.getEstatus());
				grupo1.setGrupo(grupo.getGrupo());
				grupo1.setCiclo(ciclo);
				grupo2 = grupoRepository.save(grupo1);
				response.setMessage("Guardado correcto");
				response.setData(grupo2);

			} else {
				response.setStatus("OK");
				response.setMessage("Ciclo no existe");
				response.setData(null);
			}
		}else {
			response.setStatus("ERROR");
			response.setMessage("Error al actualizar, el grupo no existe");
		}
*/
		return response;
	}

	@Override
	public Response<Grupo> buscarGrupoId(Integer idGrupo) {

		Response<Grupo> response = new Response<Grupo>();

		Grupo grupo = null;
		Optional<Grupo> optional = grupoRepository.findById(idGrupo);

		if (optional.isPresent()) {
			grupo = optional.get();
			response.setMessage("Búsqueda exitosa");
			response.setData(grupo);
		} else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");

		return response;
	}

	@Override
	public Response<Integer> eliminarGrupo(Integer idGrupo) {

		Response<Integer> response = new Response<Integer>();

		grupoRepository.deleteById(idGrupo);
		response.setData(idGrupo);
		response.setMessage("Eliminación correcta");
		response.setStatus("OK");

		return response;
	}

	@Override
	public Response<Grupo> actualizarGrupo(Grupo grupo) {
		Response<Grupo> response = new Response<Grupo>();
		
		Grupo grupoActu=grupoRepository.save(grupo);
		response.setStatus("OK");
		response.setMessage("Alumno no existe");
		response.setData(grupoActu);
/*
		Optional<Ciclo> optional = cicloRepository.findById(grupo.getIdCiclo());
		Ciclo ciclo = null;
		Grupo grupo1 = null;
		Grupo grupo2 = null;

		if (optional.isPresent()) {
			ciclo = optional.get();
			grupo1 = new Grupo();
			grupo1.setId(grupo.getId());
			grupo1.setEstatus(grupo.getEstatus());
			grupo1.setGrupo(grupo.getGrupo());
			grupo1.setCiclo(ciclo);
			grupo2 = grupoRepository.save(grupo1);
			response.setMessage("Actualización correcto");
			response.setData(grupo2);

		} else {
			response.setStatus("OK");
			response.setMessage("Ciclo no existe");
			response.setData(null);
		}

		response.setStatus("OK");
*/
		return response;
	}

	@Override
	public Response<Grupo> buscarPorNombre(String nombre) {

		Response<Grupo> response = new Response<Grupo>();

		Grupo grupo = null;
		Optional<Grupo> optional = grupoRepository.consultarPorNombre(nombre);
		if (optional.isPresent()) {
			grupo = optional.get();
			response.setData(grupo);
			response.setMessage("Búsqueda correcta");
		} else {
			response.setData(null);
			response.setMessage("Sin resultados");
		}

		response.setStatus("OK");

		return response;
	}

	@Override
	public Response<Grupo> busquedaDinamica(GrupoFiltroRequest grupo) {
		Response<Grupo> response = new Response<Grupo>();
		response=consultaGrupoRepository.busquedaGrupo(grupo);
		return response;
	}

}
