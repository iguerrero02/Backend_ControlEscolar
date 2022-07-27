package com.utng.controlescolar2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.controlescolar2.model.Status;

public interface StatusRepository  extends JpaRepository<Status, Integer> {

}
