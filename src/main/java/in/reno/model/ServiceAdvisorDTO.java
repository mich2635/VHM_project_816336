package in.reno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="select_all_SA" ,query="Select s From ServiceAdvisorDTO s")
@Table(name="Service_advisor")
public class ServiceAdvisorDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable=false)
	private String status;

	public ServiceAdvisorDTO() {
		super();
	}
	
	

	public ServiceAdvisorDTO(int id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}



	public ServiceAdvisorDTO(String name, String status, CarDTO cardto) {
		super();
		this.name = name;
		this.status = status;
	}

	public ServiceAdvisorDTO(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}

	public ServiceAdvisorDTO(int id, String name, String status, CarDTO cardto) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
