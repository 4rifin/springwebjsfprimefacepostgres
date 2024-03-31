package com.jsf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.dao.BusRepository;
import com.jsf.model.Bus;
import com.jsf.vo.BusVO;

@Service
@Transactional
public class BusService {
	@Autowired
	private BusRepository busRepository;

	public List<Bus> findAll() {
		return busRepository.findAll();
	}
	
	public List<BusVO> fetchAll() {
		List<BusVO> listBusVo = new ArrayList<>();

		findAll().stream().forEach(obj -> {
			BusVO busVo = new BusVO();
			busVo.setId(obj.getId());
			busVo.setBusOperationName(obj.getBusOperationName());
			busVo.setFromBusTerminal(obj.getFromBusTerminal());
			busVo.setToBusTerminal(obj.getToBusTerminal());
			busVo.setScheduledDateTime(obj.getScheduledDateTime());
			busVo.setEstimatedDateTime(obj.getEstimatedDateTime());
			busVo.setActualDateTime(obj.getActualDateTime());
			listBusVo.add(busVo);
		});

		return listBusVo;
	}

	public Bus findBusById(BusVO busVo) {
		Optional<Bus> bus = Optional.empty();
		if(busVo.getId() !=null) {
			bus = busRepository.findById(busVo.getId());
		}
		return bus.isPresent() ? bus.get() : null;
	}

	public void saveBus(BusVO busVo) {
		Bus bus = null;
		bus = findBusById(busVo);
		if (bus == null) {
			bus = new Bus();
		}
		bus.setBusOperationName(busVo.getBusOperationName());
		bus.setFromBusTerminal(busVo.getFromBusTerminal());
		bus.setToBusTerminal(busVo.getToBusTerminal());
		bus.setScheduledDateTime(busVo.getScheduledDateTime());
		bus.setActualDateTime(busVo.getActualDateTime());
		bus.setEstimatedDateTime(busVo.getEstimatedDateTime());
		save(bus);
	}

	public Bus save(Bus bus) {
		return busRepository.save(bus);
	}

	public void delete(Bus bus) {
		busRepository.delete(bus);
	}

	public boolean validation() {
		boolean result = false;
		if (findAll().size() <= 10) {
			result = true;
		} else {
			Optional<Bus> bus = busRepository
					.findById(findAll().stream().reduce((first, second) -> second).get().getId());
			if (bus.isPresent()) {
				delete(bus.get());
			}
		}
		return result;
	}
}
