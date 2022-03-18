package in.reno.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.reno.model.ServiceAdvisorDTO;
import in.reno.service.ServiceAdvisorService;

@RestController
public class ServiceAdvisorController {
	@Autowired
	ServiceAdvisorService serviceAdvisorService;

	@PostMapping("insertSa")
	public ServiceAdvisorDTO insertSa(@RequestParam("name") String name) {
		return serviceAdvisorService.insert(name, "idle");
	}

	@GetMapping("getAllSA")
	public ArrayList<ServiceAdvisorDTO> getAll() {
		return serviceAdvisorService.getAll();
	}

	@DeleteMapping("deleteServiceAdvisor")
	public boolean delete(@RequestParam("id") int idSA) {
		return serviceAdvisorService.deleteSA(idSA);
	}

	@PatchMapping("updateSA")
	public ServiceAdvisorDTO updateSA(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("status") String status) {
		return serviceAdvisorService.update(new ServiceAdvisorDTO(id, name, status));
	}
}
