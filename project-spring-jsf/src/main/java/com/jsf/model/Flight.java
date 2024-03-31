package com.jsf.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String airline;
	private String fromAirport;
	private String toAirport;

	private Date scheduledDateTime;
	private Date estimatedDateTime;
	private Date actualDateTime;

    
}
