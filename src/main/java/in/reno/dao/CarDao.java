package in.reno.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.reno.model.CarDTO;
import in.reno.model.ServiceAdvisorDTO;
import in.reno.model.ServiceCostDTO;

@Repository
@Transactional
public class CarDao {

	@Autowired
	EntityManager entityManager;

	public CarDTO insert(CarDTO carInfo) {
		return entityManager.merge(carInfo);

	}

	public CarDTO update(int carId, int serviceAdvisorId) {
		CarDTO carDetail = entityManager.find(CarDTO.class, carId);
		ServiceAdvisorDTO serviceAdvisorInfo = entityManager.find(ServiceAdvisorDTO.class, serviceAdvisorId);
		carDetail.setServiceAdvisor(serviceAdvisorInfo);
		carDetail.setStatus("on progress");
		serviceAdvisorInfo.setStatus("working");
		return carDetail;
	}

	public void Delete(int id) {
		CarDTO carInfo = entityManager.find(CarDTO.class, id);
		entityManager.remove(carInfo);
	}

	public CarDTO updateOnlyCarInfo(CarDTO carInfo) {
		return entityManager.merge(carInfo);
	}

	public CarDTO updateStatus(int saId, int carId) {
		CarDTO carInfo = entityManager.find(CarDTO.class, carId);
		ServiceAdvisorDTO saInfo = entityManager.find(ServiceAdvisorDTO.class, saId);
		saInfo.setStatus("idle");
		carInfo.setStatus("Done");
		return carInfo;
	}

	public ArrayList<CarDTO> selectAll() {
		return (ArrayList<CarDTO>) entityManager.createNamedQuery("select_all").getResultList();
	}

	public CarDTO updateCost(int carId, int costId) {

		CarDTO carInfo = entityManager.find(CarDTO.class, carId);
		List<ServiceCostDTO> allCost = carInfo.getCost();
		ServiceCostDTO costInfo = entityManager.find(ServiceCostDTO.class, costId);
		allCost.add(costInfo);
		carInfo.setCost(allCost);
		return carInfo;
	}
}
