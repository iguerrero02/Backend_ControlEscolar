/**
 * 
 */
package com.utng.controlescolar2.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar2.model.Alumno;
import com.utng.controlescolar2.model.AlumnoFiltroRequest;
import com.utng.controlescolar2.model.Response;

@Repository
public class ConsultaAlumnoRepository implements IConsultaAlumnoRepository{

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Response<Alumno> busquedaAlumno(AlumnoFiltroRequest filtro) {

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
