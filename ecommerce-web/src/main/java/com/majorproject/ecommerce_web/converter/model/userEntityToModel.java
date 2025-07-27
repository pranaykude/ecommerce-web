package com.majorproject.ecommerce_web.converter.model;



import org.springframework.stereotype.Component;

import com.majorproject.ecommerce_web.entity.User;
import com.majorproject.ecommerce_web.responsemodel.userResponseModel;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class userEntityToModel {


	public userResponseModel getUserDetail(User user) {
		
        log.info(" Converting User Entity to Response Model for User ID: {}", user.getUserId());
		userResponseModel responseModel = new userResponseModel();
		responseModel.setUserId(user.getUserId());
		responseModel.setFullName(user.getFullName());
		responseModel.setDob(user.getDob());
		responseModel.setEmail(user.getEmail());
		responseModel.setMobileNumber(user.getMobileNumber());
	
		responseModel.setAlternateMobileNumber(user.getAlternateMobileNumber());
		responseModel.setHintName(user.getHintName());
		 log.info(" Final Response Object for frontend: {}", responseModel);
		 
		return responseModel;
	}
	public userResponseModel getchangeStatus(User user) {
		userResponseModel responseModel = new userResponseModel();
		    responseModel.setUserId(user.getUserId());
		    responseModel.setFullName(user.getFullName());
		    responseModel.setDob(user.getDob());
		    responseModel.setEmail(user.getEmail());
		    responseModel.setMobileNumber(user.getMobileNumber());
		
		    responseModel.setIsDeleted(user.getIsDeleted()); 
		    return responseModel;
	}
	

	
	
	
}
