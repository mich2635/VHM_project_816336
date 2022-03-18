package in.reno.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reno.dao.ServiceAdvisorDAO;
import in.reno.model.ServiceAdvisorDTO;

@Service
public class ServiceAdvisorService {

	@Autowired
	ServiceAdvisorDAO serviceAdvisorDao;

	public ArrayList<ServiceAdvisorDTO> getAll() {
		return serviceAdvisorDao.getAll();
	}

	public ServiceAdvisorDTO insert(String name, String status) {
		return serviceAdvisorDao.insert(new ServiceAdvisorDTO(name, status));
	}

	public boolean deleteSA(int id) {
		serviceAdvisorDao.delete(id);
		return true;
	}

	public ServiceAdvisorDTO update(ServiceAdvisorDTO saInfo) {
		return serviceAdvisorDao.update(saInfo);
	}
}
