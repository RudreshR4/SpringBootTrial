package com.scp.java.boot.springbootapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmpService empService;

	@PostMapping("/")
	public String addEmp(@RequestBody EmpEntity entity) {
		empService.save(entity);
		return "Emp record saved Successfully...";
	}

	@GetMapping("/{entityid}")
	public Optional<EmpEntity> getEmp(@PathVariable int entityid) {
		return empService.findById(entityid);
	}

	@DeleteMapping("/{entityId}")
	public String deleteEmp(@PathVariable int entityId) {
		Optional<EmpEntity> dbentity = empService.findById(entityId);
		if(dbentity.isPresent()) {
			empService.deleteById(entityId);
			return "Emp record deleted successfully..!";
		}
		
		return "Emp record not found so cannot delete!";
	}
	
	@PutMapping
	public String updateEmp(@RequestBody EmpEntity entity) {
		empService.save(entity);
		return "Emp record updated successfully..!";
	}

	@GetMapping
	public Iterable<EmpEntity> getAllEmps() {
		return empService.findAll();
	}

}
