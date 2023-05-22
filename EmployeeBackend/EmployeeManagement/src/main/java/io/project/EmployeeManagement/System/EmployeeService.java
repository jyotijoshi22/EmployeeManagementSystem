package io.project.EmployeeManagement.System;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	//get All employee
	public List<Employee> getAll() {
		return this.repository.findAll();
	}
	
	
	//  create new employee
	public Employee create(EmployeeDTO data) {
		
		Employee newEmployee = new Employee(data.getFirstName(), data.getMiddleName(), data.getLastName(),
			    data.getEmailId(), data.getContactNumber(), data.getAddress(), data.getContractType(),
			    data.getStartDate(), data.getFinishDate(), data.getWorkTimeType(), data.getHoursPerWeek(),
			    data.isOnGoing());
		this.repository.save(newEmployee);
		return newEmployee;
	}

	//delete employee

	public boolean delete(Long id) {
		Optional<Employee> employee = this.repository.findById(id);
		if (employee.isEmpty())
			return false;

		this.repository.deleteById(id);
		return true;
	}

	//get byId

	public Optional<Employee> getById(Long id) {
		return this.repository.findById(id);
	}

}
