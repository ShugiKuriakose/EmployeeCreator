package io.nology.EmployeeCreator.Posts;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class UpdateEmployeeDto {

	
	@Size(min = 1)
		String name;
	@Size(min = 1)
		String employmentType;
	@Size(min = 1)
		String email;
	@Size(min = 1)
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


