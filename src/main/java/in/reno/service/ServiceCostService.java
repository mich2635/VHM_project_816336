package in.reno.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reno.dao.CarDao;
import in.reno.dao.ServiceCostDAO;
import in.reno.model.CarDTO;
import in.reno.model.ServiceCostDTO;

@Service
public class ServiceCostService {

	@Autowired
	ServiceCostDAO serviceCostDAO;

	@Autowired
	CarDao carDao;

	public ServiceCostDTO insert(String name, int cost) {
		return serviceCostDAO.insert(new ServiceCostDTO(name, cost));
	}

	public ArrayList<ServiceCostDTO> getAll() {
		return serviceCostDAO.getAll();
	}

	public boolean delete(int id) {
		serviceCostDAO.delete(id);
		return true;
	}

	public ServiceCostDTO update(ServiceCostDTO costInfo) {
		return serviceCostDAO.update(costInfo);
	}

	public boolean updateCost(int carId, Integer[] costIds) {

		for (int i = 0; i <= costIds.length; i++) {
			carDao.updateCost(carId, costIds[i]);
		}
		return true;
	}
}
