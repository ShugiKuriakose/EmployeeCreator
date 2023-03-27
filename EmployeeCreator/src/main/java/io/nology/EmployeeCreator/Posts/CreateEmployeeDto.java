package io.nology.EmployeeCreator.Posts;

import jakarta.validation.constraints.NotBlank;

public class CreateEmployeeDto {
	
	@NotBlank
	String name;
	@NotBlank
	String employmentType;
	@NotBlank
	String email;

	int yearsEmployed;
	
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


}
