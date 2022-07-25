/**
 * 
 */
package com.utng.controlescolar2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar2.model.Alumno;
import com.utng.controlescolar2.model.AlumnoFiltroRequest;
import com.utng.controlescolar2.model.AlumnoRequest;
import com.utng.controlescolar2.model.Ciclo;
import com.utng.controlescolar2.model.Response;
import com.utng.controlescolar2.repository.AlumnoRepository;
import com.utng.controlescolar2.repository.CicloRepository;
import com.utng.controlescolar2.repository.ConsultaAlumnoRepository;

@Service
public class AlumnoService implements IAlumnoService{

	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private ConsultaAlumnoRepository consultaAlumnoRepository;
	@Autowired
	private CicloRepository cicloRepository;
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Response<Alumno> consultarTodos() {
		
		Response<Alumno> response= new Response<Alumno>();
		List<Alumno> lista = alumnoRepository.findAll();
		
		if (lista.isEmpty()) {
			response.setMessage("No hay resultados");
		}else {
			response.setMessage("Consulta correcta");
		}
		response.setStatus("OK");
		response.setList(lista);
		response.setCount(lista.size());
		
		return response;
	}
/*
	@Override
	public Response<Alumno> buscarAlumnoDinamica(AlumnoFiltroRequest alumno) {
		
		public Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder(); 

		CriteriaQuery<Alumno> cq = cb.createQuery(Alumno.class);

		Root<Alumno> root = cq.from(Alumno.class);

		List<Predicate> predicados = new ArrayList<Predicate>();
		if (filtro.getId() != null && !filtro.getId().isEmpty()) {

			predicados.add(cb.like(root.get("id"), "%" + filtro.getId() + "%"));

		}
		if (filtro.getExpediente() != null && !filtro.getExpediente().isEmpty()) { // No sea nulo o este vacio

			predicados.add(cb.like(root.get("expediente"), "%" + filtro.getExpediente() + "%"));// Busca dentro del campo clave y compara si es igual con el que se ingresó

		}

		if (filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {

			predicados.add(cb.like(root.get("nombre"), "%" + filtro.getNombre() + "%"));

		}
		
		if (filtro.getCurp() != null && !filtro.getCurp().isEmpty()) {

			predicados.add(cb.like(root.get("curp"), "%" + filtro.getCurp() + "%"));

		}
		
		if (filtro.getCorreo() != null && !filtro.getCorreo().isEmpty()) {

			predicados.add(cb.like(root.get("correo"), "%" + filtro.getCorreo() + "%"));

		}

		if (!predicados.isEmpty()) {

			Predicate[] pr = new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);

		}

		cq.orderBy(cb.desc(root.get("id")));

		CriteriaQuery<Alumno> select = cq.select(root);
		TypedQuery<Alumno> typeQuery = entityManager.createQuery(select);

		List<Alumno> lista = typeQuery.getResultList();
		Response<Alumno> response = new Response<>();
		response.setList(lista);
		response.setStatus("OK");
		response.setMessage("Consulta exitosa!!");

		return response;
	}
	}
*/
	@Override
	public Response<Alumno> guardar(Alumno alumno) {
		Response<Alumno> response = new Response<Alumno>();
		
		Alumno alumnoNuevo = alumnoRepository.save(alumno);
		response.setStatus("OK");
		response.setMessage("Alumno no existe");
		response.setData(alumnoNuevo);
		
/*
		Optional<Ciclo> optional = cicloRepository.findById(alumno.getIdCiclo());
		Ciclo ciclo = null;
		Alumno alumno1 = null;
		Alumno alumno2 = null;

		if (optional.isPresent()) {
			ciclo = optional.get();
			alumno1 = new Alumno();
			alumno1.setEstatus(alumno.getEstatus());
			alumno1.setCiclo(ciclo);
			alumno1.setCorreo(alumno.getCorreo());
			alumno1.setGenero(alumno.getGenero());
			alumno1.setCurp(alumno.getCurp());
			alumno1.setNombre(alumno.getNombre());
			alumno1.setExpediente(alumno.getExpediente());
			alumno2 = alumnoRepository.save(alumno1);
			response.setMessage("Guardado correcto");
			response.setData(alumno2);

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
	public Response<Alumno> buscarAlumnoId(Integer idAlumno) {
		Response<Alumno> response = new Response<Alumno>();

		Alumno alumno = null;
		Optional<Alumno> optional = alumnoRepository.findById(idAlumno);

		if (optional.isPresent()) {
			alumno = optional.get();
			response.setMessage("Búsqueda exitosa");
			response.setData(alumno);
		} else {
			response.setMessage("Sin resultados");
			response.setData(null);
		}
		response.setStatus("OK");

		return response;
	}

	@Override
	public Response<Integer> eliminarAlumno(Integer idAlumno) {

		Response<Integer> response = new Response<Integer>();

		alumnoRepository.deleteById(idAlumno);
		response.setData(idAlumno);
		response.setMessage("Eliminación correcta");
		response.setStatus("OK");

		return response;
		
	}

	@Override
	public Response<Alumno> actualizarAlumno(Alumno alumno) {
		Response<Alumno> response = new Response<Alumno>();
		
		Alumno alumnoActu = alumnoRepository.save(alumno);
		response.setStatus("OK");
		response.setMessage("Alumno no existe");
		response.setData(alumnoActu);
/*
		Optional<Ciclo> optional = cicloRepository.findById(alumno.getIdCiclo());
		Optional<Alumno> optionalA = alumnoRepository.findById(alumno.getIdAlumno());
		
		Ciclo ciclo = null;
		Alumno alumno1 = null;
		Alumno alumno2 = null;

		if(optionalA.isPresent()) {
			if (optional.isPresent()) {
				
				ciclo = optional.get();
				alumno1 = new Alumno();
				alumno1.setIdAlumno(alumno.getIdAlumno());
				alumno1.setEstatus(alumno.getEstatus());
				alumno1.setCiclo(ciclo);
				alumno1.setCorreo(alumno.getCorreo());
				alumno1.setGenero(alumno.getGenero());
				alumno1.setCurp(alumno.getCurp());
				alumno1.setNombre(alumno.getNombre());
				alumno1.setExpediente(alumno.getExpediente());
				alumno2 = alumnoRepository.save(alumno1);
				response.setMessage("Actualización correcta");
				response.setData(alumno2);
				response.setStatus("OK");

			} else {
				response.setStatus("OK");
				response.setMessage("Ciclo no existe");
				response.setData(null);
			}
		}else {
			response.setStatus("ERROR");
			response.setMessage("Error al actualizar, el alumno no existe");
		}
*/
		return response;
	}
	@Override
	public Response<Alumno> buscarAlumnoDinamica(AlumnoFiltroRequest filtro) {
		

			CriteriaBuilder cb = entityManager.getCriteriaBuilder(); 

			CriteriaQuery<Alumno> cq = cb.createQuery(Alumno.class);

			Root<Alumno> root = cq.from(Alumno.class);

			List<Predicate> predicados = new ArrayList<Predicate>();
			if (filtro.getIdAlumno() != null && !filtro.getIdAlumno().isEmpty()) {

				predicados.add(cb.like(root.get("id"), "%" + filtro.getIdAlumno() + "%"));

			}
			if (filtro.getExpediente() != null && !filtro.getExpediente().isEmpty()) { // No sea nulo o este vacio

				predicados.add(cb.like(root.get("expediente"), "%" + filtro.getExpediente() + "%"));// Busca dentro del campo clave y compara si es igual con el que se ingresó

			}

			if (filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {

				predicados.add(cb.like(root.get("nombre"), "%" + filtro.getNombre() + "%"));

			}
			
			if (filtro.getCurp() != null && !filtro.getCurp().isEmpty()) {

				predicados.add(cb.like(root.get("curp"), "%" + filtro.getCurp() + "%"));

			}
			
			if (filtro.getCorreo() != null && !filtro.getCorreo().isEmpty()) {

				predicados.add(cb.like(root.get("correo"), "%" + filtro.getCorreo() + "%"));

			}

			if (!predicados.isEmpty()) {

				Predicate[] pr = new Predicate[predicados.size()];
				predicados.toArray(pr);
				cq.where(pr);

			}

			cq.orderBy(cb.desc(root.get("id")));

			CriteriaQuery<Alumno> select = cq.select(root);
			TypedQuery<Alumno> typeQuery = entityManager.createQuery(select);

			List<Alumno> lista = typeQuery.getResultList();
			Response<Alumno> response = new Response<>();
			response.setList(lista);
			response.setStatus("OK");
			response.setMessage("Consulta exitosa!!");

			return response;
		}
	

}
