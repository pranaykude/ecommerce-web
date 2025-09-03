package com.majorproject.ecommerce_web.responsemodel;

import java.util.Date;

import com.majorproject.ecommerce_web.entity.User;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class loginResponseModel {

	private int userId;
	private String fullName;
	private String email;
	private String gender;
	private Date dob;
	private String mobileNumber;
	private String alternateMobileNumber;
	private String location;
	private String hintName;

	// This must go AFTER field declarations, outside any method
	public loginResponseModel(User user) {
		this.userId = user.getUserId();
		this.fullName = user.getFullName();
		this.email = user.getEmail();
		this.gender = user.getGender();
		this.dob = user.getDob();
		this.mobileNumber = user.getMobileNumber();
		this.alternateMobileNumber = user.getAlternateMobileNumber();
		this.hintName = user.getHintName();
	}
}
