package in.reno.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.reno.model.ServiceAdvisorDTO;

@Repository
@Transactional
public class ServiceAdvisorDAO {

	@Autowired
	EntityManager entityManager;

	public ServiceAdvisorDTO insert(ServiceAdvisorDTO serviceAdvisor) {
		return entityManager.merge(serviceAdvisor);
	}

	public ArrayList<ServiceAdvisorDTO> getAll() {
		return (ArrayList<ServiceAdvisorDTO>) entityManager.createNamedQuery("select_all_SA").getResultList();
	}

	public void delete(int id) {
		ServiceAdvisorDTO SAInfo = entityManager.find(ServiceAdvisorDTO.class, id);
		entityManager.remove(SAInfo);
	}

	public ServiceAdvisorDTO update(ServiceAdvisorDTO SAInfo) {
		return entityManager.merge(SAInfo);
	}
}
