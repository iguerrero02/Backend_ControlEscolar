package com.utng.controlescolar2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.controlescolar2.model.Profesor;
import com.utng.controlescolar2.model.ProfesorMateria;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{

}
