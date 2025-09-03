package com.majorproject.ecommerce_web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.majorproject.ecommerce_web.converter.entity.userModelToEntity;
import com.majorproject.ecommerce_web.converter.model.userEntityToModel;
import com.majorproject.ecommerce_web.entity.User;
import com.majorproject.ecommerce_web.repo.userRepo;
import com.majorproject.ecommerce_web.requestmodel.loginRequestModel;
import com.majorproject.ecommerce_web.requestmodel.userEditRequestModel;
import com.majorproject.ecommerce_web.requestmodel.userSignupRequestModel;
import com.majorproject.ecommerce_web.responsemodel.loginResponseModel;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	


	public userResponseModel Signup (userSignupRequestModel usersignupRequestModel) throws Exception {
		
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
	   
	   log.info("Encoding raw password before saving to DB...");
	   String encodePassword = passwordEncoder.encode(usersignupRequestModel.getPassword());
	   SaveUser.setPassword(encodePassword);
	   log.debug("Encoded password: {}", encodePassword);
	   
	   User savedUser = userRepo.save(SaveUser);
	
         log.info(" User saved to DB: {}", savedUser);
	   return  userEntityToModel.getUserDetail(savedUser);
	}


	public loginResponseModel Login(loginRequestModel loginRequestModel) {
	    
		log.info("Get user by email only");
	    User user = userRepo.findbyEmail(loginRequestModel.getEmail());
	   
	    log.error("User not found .....");
	    if (user == null ) {
	        throw new RuntimeException("User not found or User does not exist......");
	    }
	    log.info("Match raw password(coming from frontend) with stored hashes password in DB .");
	    String rawPassword = loginRequestModel.getPassword().trim();
	    String storedPassword = user.getPassword();

	    if (passwordEncoder.matches(rawPassword, storedPassword)) {
	    	log.info("login succesful....",new loginResponseModel(user));
	        return new loginResponseModel(user);
	    } else {
	    	log.error("Invalid password");
	        throw new RuntimeException("Invalid password....");
	    }
	}
	
	
	public userResponseModel userEditProfile(userEditRequestModel editRequestModel) throws Exception {

	    log.info("Received profile edit request for user ID: {}", editRequestModel.getUserId());
	    Optional<User> byId = userRepo.findById(editRequestModel.getUserId());
	    if (byId.isEmpty()) {
	        log.error("User account not found for ID: {}", editRequestModel.getUserId());
	        throw new Exception("User account does not exist.");
	    }
	    User existingUser = byId.get();
	     log.info("Update the existing user entity with new data");
	    User updatedUser = modelToEntity.EditUser(editRequestModel, existingUser);

	    log.info("Save updated user");
	    User savedUser = userRepo.save(updatedUser);
	    log.info("User profile updated successfully for user ID: {}", savedUser.getUserId());
	    
	    return userEntityToModel.getUserDetail(savedUser);
	}
	
	
	
	public userResponseModel changestatus(Integer id, Integer status) throws Exception {
		Optional<User> optional = userRepo.findById(id);

		if (optional.isEmpty()) {
			throw new Exception("The user account does not exist");
		}
		User user = optional.get();
		user.setIsDeleted(status);
		userRepo.save(user);
		return userEntityToModel.getchangeStatus(user);

	}
	
	
}
