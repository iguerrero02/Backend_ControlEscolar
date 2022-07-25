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

import com.utng.controlescolar2.model.Ciclo;
import com.utng.controlescolar2.model.Grupo;
import com.utng.controlescolar2.model.GrupoFiltroRequest;
import com.utng.controlescolar2.model.Response;

@Repository
public class ConsultaGrupoRepository implements IConsultaGrupoRepository{
	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Response<Grupo> busquedaGrupo(GrupoFiltroRequest filtro) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Grupo> cq = criteriaBuilder.createQuery(Grupo.class);

		Root<Grupo> root = cq.from(Grupo.class);

		List<Predicate> predicados = new ArrayList<Predicate>();

		if (filtro.getGrupo() != null && !filtro.getGrupo().isEmpty()) {
			//Aqui se pueden optener las conidicones de =
			
			predicados.add(
					criteriaBuilder.like(
							root.get("grupo"), 
							"%"+filtro.getGrupo()+"%"));			
		}
		/*
		if (filtro.getEstatus() != null && !filtro.getEstatus().isEmpty()) {

			predicados.add(
					criteriaBuilder.like(
							root.get("nombre"), 
							"%"+filtro.getEstatus()+"%"));
		}
		
		if (filtro.getIdCiclo() != null&& !filtro.getIdCiclo().isEmpty()) {
			

			predicados.add(
					criteriaBuilder.like(
							root.get("idCiclo"), 
							"%"+filtro.getEstatus()+"%"));
		}
		*/
		if (!predicados.isEmpty()) {
			Predicate[] pr= new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);
		}
		
		//cq.where(criteriaBuilder.like(root.get("nombre"), filtro.getNombre()));
		cq.orderBy(criteriaBuilder.asc(root.get("id")));
		
		
		CriteriaQuery<Grupo> select= cq.select(root);
				
		
		TypedQuery<Grupo> typedQuery= entityManager.createQuery(select);
		
		List<Grupo> lista= typedQuery.getResultList();
		
		Response<Grupo> response= new Response<Grupo>();
		
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
