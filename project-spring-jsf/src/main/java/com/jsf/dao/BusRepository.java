package com.jsf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsf.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

}
