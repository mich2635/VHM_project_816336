package in.reno.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.reno.model.AdminDTO;

@Repository
@Transactional
public class AdminDao {

	@Autowired
	EntityManager entityManager;

	public AdminDTO insert(AdminDTO adminInfo) {
		return entityManager.merge(adminInfo);
	}

}
