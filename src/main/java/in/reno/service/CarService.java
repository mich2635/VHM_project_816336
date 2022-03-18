package in.reno.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reno.dao.CarDao;
import in.reno.model.CarDTO;

@Service
public class CarService {

	@Autowired
	CarDao carDao;

	public CarDTO insert(String name,String status) {
		return carDao.insert(new CarDTO(name,status));
	}
	
	public ArrayList<CarDTO> getAllCarDetails() {
		return carDao.selectAll();
	}

	public boolean deleteCar(int id) {
		carDao.Delete(id);
		return true;
	}

	public CarDTO updateOnlyCarInfo(CarDTO carInfo) {
		return carDao.updateOnlyCarInfo(carInfo);
	}

	public CarDTO update(int carId, int saId) {
		return carDao.update(carId, saId);
	}

	public CarDTO updateStatus(int saId, int carId) {
		return carDao.updateStatus(saId, carId);
	}
}
