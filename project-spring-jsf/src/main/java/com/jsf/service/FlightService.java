package com.jsf.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.dao.FlightRepository;
import com.jsf.model.Flight;

@Service
@Transactional
public class FlightService {
	@Autowired
	private FlightRepository flightRepository;

	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

	public Flight save (Flight flight) {
		return flightRepository.save(flight);
	}
}
