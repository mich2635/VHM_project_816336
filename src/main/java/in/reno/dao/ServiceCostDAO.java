package in.reno.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.reno.model.ServiceCostDTO;

@Repository
@Transactional
public class ServiceCostDAO {

	@Autowired
	EntityManager entityManager;

	public ArrayList<ServiceCostDTO> getAll() {
		return (ArrayList<ServiceCostDTO>) entityManager.createNamedQuery("select_all_sCost").getResultList();
	}

	public ServiceCostDTO insert(ServiceCostDTO cost) {
		return entityManager.merge(cost);
	}

	public void delete(int id) {
		ServiceCostDTO costInfo = entityManager.find(ServiceCostDTO.class, id);
		entityManager.remove(costInfo);
	}
	public ServiceCostDTO update(ServiceCostDTO costInfo) {
		return entityManager.merge(costInfo);
	}
	
}
