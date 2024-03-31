package com.jsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsf.model.Bus;
import com.jsf.service.BusService;
import com.jsf.vo.BusVO;

@Named
@ViewScoped
public class BusController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 581453877192605965L;

	private Bus bus = new Bus();
	private BusVO busVo = new BusVO();
	private List<Bus> listBus = new ArrayList<>();
	private List<BusVO> listBusVo = new ArrayList<>();

	@Autowired
	private BusService busService;

	@PostConstruct
	public void init() {
		fetchAll();
		refresh();
	}

	public void fetchAll() {
		listBusVo = busService.fetchAll();
		refresh();
	}

	public void save() {
		String message = "";
		busService.saveBus(busVo);
		fetchAll();
		if (busService.validation()) {
			message = "Succes Save";
		} else {
			fetchAll();
			message = "Failed Save";
		}
		message(message);

	}

	public void delete(BusVO busVo) {
		bus = busService.findBusById(busVo);
		if (bus != null) {
			busService.delete(bus);
			fetchAll();
			message("Succes Delete");
		} else {
			message("Failed Delete");
		}
	}

	public void edit(BusVO bus) {
		this.busVo = bus;
	}

	public void refresh() {
		busVo = new BusVO();
		busVo.setScheduledDateTime(GregorianCalendar.getInstance().getTime());
		busVo.setActualDateTime(GregorianCalendar.getInstance().getTime());
		busVo.setEstimatedDateTime(GregorianCalendar.getInstance().getTime());
	}

	public void message(String message) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage(message.contains("Failed") ? FacesMessage.SEVERITY_ERROR : FacesMessage.SEVERITY_INFO,
						"Message", message));
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public List<Bus> getListBus() {
		return listBus;
	}

	public void setListBus(List<Bus> listBus) {
		this.listBus = listBus;
	}

	public BusService getBusService() {
		return busService;
	}

	public void setBusService(BusService busService) {
		this.busService = busService;
	}

	public BusVO getBusVo() {
		return busVo;
	}

	public void setBusVo(BusVO busVo) {
		this.busVo = busVo;
	}

	public List<BusVO> getListBusVo() {
		return listBusVo;
	}

	public void setListBusVo(List<BusVO> listBusVo) {
		this.listBusVo = listBusVo;
	}

}
