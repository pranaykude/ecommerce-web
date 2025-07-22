package com.majorproject.ecommerce_web.converter.entity;

import org.springframework.stereotype.Component;

import com.majorproject.ecommerce_web.entity.User;
import com.majorproject.ecommerce_web.requestmodel.userSignupRequestModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class userModelToEntity {

	

	public User SaveUser(userSignupRequestModel usersignupRequestModel) throws Exception {
		
		log.info("Received signup request: {}", usersignupRequestModel); 
		
		User user = new User();
		user.setFullName(usersignupRequestModel.getFullName());
		user.setLocation(usersignupRequestModel.getLocation());
		user.setMobileNumber(usersignupRequestModel.getMobileNumber());
		user.setDob(usersignupRequestModel.getDob());
		user.setGender(usersignupRequestModel.getGender());
		user.setAlternateMobileNumber(usersignupRequestModel.getAlternateMobileNumber());
		user.setEmail(usersignupRequestModel.getEmail());
		user.setHintName(usersignupRequestModel.getHintName());
	    
		log.info("Mapped User entity: {}", user);  

		return user;		
	}
}
