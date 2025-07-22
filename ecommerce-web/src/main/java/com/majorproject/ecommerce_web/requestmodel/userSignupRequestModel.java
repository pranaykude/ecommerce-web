package com.majorproject.ecommerce_web.requestmodel;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class userSignupRequestModel {

	 private int userId;
	 @NotBlank(message = "full must  required")
	 private String fullName;
	 @Email(message = "Invalid email format")
	 private String email;
	 @NotBlank(message = "mobilenumber must required ")
	 private String mobileNumber;
	 private String gender;
	 private String location;
	 private String password;
	 private Date dob;
	 private String alternateMobileNumber;
	 private String hintName;
	
}
