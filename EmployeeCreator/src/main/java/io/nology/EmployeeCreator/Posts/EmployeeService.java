package io.nology.EmployeeCreator.Posts;

import java.util.List;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	@Autowired
//	private ModelMapper mapper;
	
	public Employee create(CreateEmployeeDto data) {
		String employeeName = data.getName().trim();
		String employeeEmploymentType = data.getEmploymentType();
		String employeeEmail = data.getEmail();
		int employeeYearsEmployed = data.getYearsEmployed();
		Employee newEmployee = new Employee();
		newEmployee.setName(employeeName);
		newEmployee.setEmploymentType(employeeEmploymentType);
		newEmployee.setEmail(employeeEmail);
		newEmployee.setYearsEmployed(employeeYearsEmployed);
		
		return this.employeeRepository.save(newEmployee);
		
	}
	
	public List<Employee> findAll(){
		return this.employeeRepository.findAll();
	}

	public Optional<Employee> findById(Long id){
		return this.employeeRepository.findById(id);
	}
	
	public void deleteById(Long id){
		this.employeeRepository.deleteById(id);
	}
	
//	public Optional<Employee> updateById(Long id, UpdateEmployeeDto data) {
//		Optional<Employee> maybeEmployee = this.findById(id);
//		if (maybeEmployee.isEmpty()) {
//			return maybeEmployee;
//		}
//		Employee existingEmployee = maybeEmployee.get();
//		// without model Mapper we'd have to do this for every field
////		if(data.getTitle() != null) {
////			existingPost.setTitle(data.getTitle().trim());
////		}
//		// JS equivalent
//		// existingPost = {...existingPost, ...data}
//		mapper.map(data, existingEmployee);
//		return Optional.of(this.employeeRepository.save(existingEmployee));
//
//	}

}
