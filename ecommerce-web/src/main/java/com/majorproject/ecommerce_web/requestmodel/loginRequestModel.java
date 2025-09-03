package com.majorproject.ecommerce_web.requestmodel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class loginRequestModel {

	@NotBlank(message = "email required ")
	@Email(message = "Invalid email format")
	private String email;
	private String  password;
	
	
	
}
