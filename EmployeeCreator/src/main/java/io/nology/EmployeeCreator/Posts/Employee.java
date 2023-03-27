package io.nology.EmployeeCreator.Posts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity()
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column
	String name;
	@Column
	String employmentType;
	@Column
	String email;
	@Column
	int yearsEmployed;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getYearsEmployed() {
		return yearsEmployed;
	}
	public void setYearsEmployed(int yearsEmployed) {
		this.yearsEmployed = yearsEmployed;
	}
	
public Employee(Long id, String name, String employmentType, String email, int yearsEmployed) {
	super();
	this.id = id;
	this.name = name;
	this.employmentType = employmentType;
	this.email = email;
	this.yearsEmployed = yearsEmployed;
		
	}
	
	public Employee() {
		
	}

}
