package com.jsf.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String busOperationName;
	private String fromBusTerminal;
	private String toBusTerminal;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduledDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date estimatedDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date actualDateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBusOperationName() {
		return busOperationName;
	}
	public void setBusOperationName(String busOperationName) {
		this.busOperationName = busOperationName;
	}
	public String getFromBusTerminal() {
		return fromBusTerminal;
	}
	public void setFromBusTerminal(String fromBusTerminal) {
		this.fromBusTerminal = fromBusTerminal;
	}
	public String getToBusTerminal() {
		return toBusTerminal;
	}
	public void setToBusTerminal(String toBusTerminal) {
		this.toBusTerminal = toBusTerminal;
	}
	public Date getScheduledDateTime() {
		return scheduledDateTime;
	}
	public void setScheduledDateTime(Date scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}
	public Date getEstimatedDateTime() {
		return estimatedDateTime;
	}
	public void setEstimatedDateTime(Date estimatedDateTime) {
		this.estimatedDateTime = estimatedDateTime;
	}
	public Date getActualDateTime() {
		return actualDateTime;
	}
	public void setActualDateTime(Date actualDateTime) {
		this.actualDateTime = actualDateTime;
	}

    
}
