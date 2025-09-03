package com.majorproject.ecommerce_web.responsemodel;



import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class userResponseModel {

	private int userId;
	private String fullName;
	private String email;
	private String gender;
	private Date dob;
	private String mobileNumber;
	private String alternateMobileNumber;
	private String location ;
	private String hintName;
	private int isDeleted;
}
