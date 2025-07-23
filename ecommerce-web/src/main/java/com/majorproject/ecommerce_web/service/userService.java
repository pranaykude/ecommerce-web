package com.majorproject.ecommerce_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorproject.ecommerce_web.converter.entity.userModelToEntity;
import com.majorproject.ecommerce_web.converter.model.userEntityToModel;
import com.majorproject.ecommerce_web.entity.User;
import com.majorproject.ecommerce_web.repo.userRepo;
import com.majorproject.ecommerce_web.requestmodel.userSignupRequestModel;
import com.majorproject.ecommerce_web.responsemodel.userResponseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class userService {
	
	@Autowired
	private userRepo userRepo;
	
	@Autowired
	private userModelToEntity modelToEntity;
	
	@Autowired
	private userEntityToModel userEntityToModel;

	
	public userResponseModel Register (userSignupRequestModel usersignupRequestModel) throws Exception {
		
	  log.info(" Received signup request: {}", usersignupRequestModel);
	  log.info(" Checking if email already exists: {}", usersignupRequestModel.getEmail());
	 
	  User byEmail = userRepo.findbyEmail(usersignupRequestModel.getEmail());
	  if(byEmail != null) {
		  throw new Exception("An account with this email already exists. Please use another email.");
	  }
	  log.info("Checking if mobile number already exists: {}", usersignupRequestModel.getMobileNumber());
	  
	  User byMobileNumber = userRepo.findbyMobileNumber(usersignupRequestModel.getMobileNumber());
	  if(byMobileNumber != null) {
		  throw new Exception("An account with this mobileNumber already exists. Please use another mobileNumber.");
	  }	
	    log.info("Mapping request to entity...");
	  
	   User  SaveUser = modelToEntity.SaveUser(usersignupRequestModel);	  
	     
	   User savedUser = userRepo.save(SaveUser);
	 
//	     log.info("User saved with ID: {}", savedUser.getUserId());
         log.info(" User saved to DB: {}", savedUser);
	   return  userEntityToModel.getUserDetail(savedUser);
	}


	
	
	
	
	
	
	
	
}
