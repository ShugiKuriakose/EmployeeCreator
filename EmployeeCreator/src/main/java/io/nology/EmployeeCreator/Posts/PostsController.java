package io.nology.EmployeeCreator.Posts;


import java.util.List;
import io.nology.EmployeeCreator.exception.NotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostsController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> createPost(@Valid @RequestBody CreateEmployeeDto data) {
		Employee createdEmployee =  this.employeeService.create(data);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAll(){
		List<Employee> allEmployees = this.employeeService.findAll();	
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
		
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getById(@PathVariable Long id){
		Optional<Employee> maybeEmployee = this.employeeService.findById(id);
		
		if (maybeEmployee.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(maybeEmployee.get(), HttpStatus.OK);
		
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteById(@PathVariable Long id){
		Optional<Employee> maybeEmployee = this.employeeService.findById(id);
		
		if (maybeEmployee.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		this.employeeService.deleteById(id);
		
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		
		
	}
	
//	@PatchMapping("/{id}")
//	public ResponseEntity<Employee> updateById(@PathVariable Long id, @Valid @RequestBody UpdateEmployeeDto data) {
//		Employee updatedEmployee = this.employeeService.updateById(id, data)
//				.orElseThrow(() -> new NotFoundException("Could not find employee with id " + id));
//
//		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
//
//	}
	}
	


