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

import com.utng.controlescolar2.model.Materia;
import com.utng.controlescolar2.model.ProfesorMateria;
import com.utng.controlescolar2.model.ProfesorMateriaFiltroRequest;
import com.utng.controlescolar2.model.Response;
@Repository
public class ConsultaProfesorMateriaRepository implements IConsultaProfesorMateriaRepository {
	@PersistenceContext
	@Autowired (required=false)
	private EntityManager entityManager;
	
	@Override
	public Response<ProfesorMateria> busquedaProfesorMateria(ProfesorMateriaFiltroRequest filtro) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<ProfesorMateria> cq = criteriaBuilder.createQuery(ProfesorMateria.class);

		Root<ProfesorMateria> root = cq.from(ProfesorMateria.class);

		List<Predicate> predicados = new ArrayList<Predicate>();

		if (filtro.getClave() != null && !filtro.getClave().isEmpty()) {

			//Aqui se pueden optener las conidicones de =
			
			predicados.add(criteriaBuilder.like(root.get("clave"), "%"+filtro.getClave()+"%" ));
			
			
		}
		if (filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {

			
			predicados.add(
					criteriaBuilder.like(
							root.get("nombre"), 
							"%"+filtro.getNombre()+"%"));
		}
		
		if (filtro.getCiclo() != null&&!filtro.getCiclo().isEmpty()) {
		
					
					predicados.add(
							criteriaBuilder.equal(
									root.get("ciclo"), 
								filtro.getCiclo()));

	}
if (filtro.getProfesor() != null && !filtro.getProfesor().isEmpty()) {

			
			predicados.add(
					criteriaBuilder.like(
							root.get("profesor"), 
							"%"+filtro.getProfesor()+"%"));
		}

		
		
		if (!predicados.isEmpty()) {
			Predicate[] pr= new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);
		}
		
		cq.orderBy(criteriaBuilder.desc(root.get("id_Pr_Ma_Fr")));
		
		CriteriaQuery<ProfesorMateria> select= cq.select(root);
		
		TypedQuery<ProfesorMateria> typedQuery= entityManager.createQuery(select);
		
		List<ProfesorMateria> lista= typedQuery.getResultList();
		
		Response<ProfesorMateria> response= new Response<ProfesorMateria>();
		
		if (!lista.isEmpty()) {
			response.setList(lista);
			response.setStatus("OK");
			response.setMessage("Consulta exitosa");
			response.setCount(lista.size());
		}else {
			response.setMessage("Sin resultados");
			response.setStatus("OK");
		}
		

		return response;
	}
	}


