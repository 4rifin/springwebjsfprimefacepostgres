package com.jsf.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BusVO {
	private Long id;
	private String busOperationName;
	private String fromBusTerminal;
	private String toBusTerminal;
	private Date scheduledDateTime;
	private Date estimatedDateTime;
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
