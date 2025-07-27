package com.majorproject.ecommerce_web.requestmodel;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class userEditRequestModel {

	
	 private int userId;
	 @NotBlank(message = "fullname is  must  required")
	 private String fullName;
	 @Email(message = "Invalid email format")
	 @NotBlank
	 private String email;
	 @NotBlank(message = "mobilenumber must required ")
	 private String mobileNumber;
	 private String gender;
	 private String location;
	 private Date dob;
	 private String alternateMobileNumber;
	 private String hintName;
	
}
