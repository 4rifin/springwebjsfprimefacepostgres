package com.jsf.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsf.model.Flight;
import com.jsf.service.FlightService;

@Named
@ViewScoped
public class FlightController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2215097218630480418L;

	private Flight flight = new Flight();

	private List<Flight> flights = new ArrayList<>();

	@Autowired
	private FlightService flightService;

	public void fetchAll() {
		flights = flightService.findAll();
	}

	public void save() {
		flightService.save(flight);
		flight = new Flight();
		flights = flightService.findAll();
	}

	public void edit(Flight flight) {
		this.flight = flight;
	}

	public void refresh() {
		flight = new Flight();
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
}
