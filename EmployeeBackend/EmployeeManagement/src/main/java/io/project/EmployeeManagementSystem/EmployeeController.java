package io.project.EmployeeManagementSystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	
	//get all employees
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAll(){
		
		List<Employee> allEmployee = this.service.getAll();
		
		return new ResponseEntity<>(allEmployee, HttpStatus.OK);
		
	}

	
	
	//get an employee by id
		@GetMapping("/employee/{id}")
		public ResponseEntity<Employee> getById(@PathVariable Long id) {
			Optional<Employee> maybeEmployee = this.service.getById(id);
			
			if (maybeEmployee.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(maybeEmployee.get(), HttpStatus.FOUND);
			}
		}
		
		
		
//create  new employee
	@PostMapping("/create")
	public ResponseEntity<Employee> create( @RequestBody EmployeeDTO data) {
		
		Employee createdEmployee = this.service.create(data);
		
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
// delete employee	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> delete(@PathVariable("Id") Long id) {
	    this.service.delete(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
