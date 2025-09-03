package com.majorproject.ecommerce_web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.majorproject.ecommerce_web.requestmodel.loginRequestModel;
import com.majorproject.ecommerce_web.requestmodel.userEditRequestModel;
import com.majorproject.ecommerce_web.requestmodel.userSignupRequestModel;
import com.majorproject.ecommerce_web.responsemodel.loginResponseModel;
import com.majorproject.ecommerce_web.responsemodel.userResponseModel;
import com.majorproject.ecommerce_web.restResponse.RestResponse;
import com.majorproject.ecommerce_web.service.userService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class userController {
	
	
	@Autowired
	private userService service ;
	
	public userController() {
		
		log.info("usercontroller : object is created ");
	}
	
	@Operation(summary = "Used this method to Register/Signup a New USER ")
	@RequestMapping(method =RequestMethod.POST, value="/Signup"  ,  consumes="application/json" ,  produces="application/json" )
	public RestResponse Signup(@Valid @RequestBody userSignupRequestModel userSignupRequestModel) {	
        log.info(" Incoming user signup request: {}", userSignupRequestModel);
	   try {
		   userResponseModel responseModel = service.Signup(userSignupRequestModel);
           log.info(" User registered successfully: {}", responseModel);
		   return RestResponse.build().withSuccess("user resgistred succesfully ",responseModel);
  	   }
	    catch (Exception e) {
          log.error(" Failed to register user: {}", e.getMessage(), e);
		  return RestResponse.build().withError(e.getMessage());
		}
		
	}
	
	
	@Operation(summary = "Used this method to Login an existing USER")
	@PostMapping( value = "/Login", consumes = "application/json", produces = "application/json")
	public RestResponse Login(@Valid @RequestBody loginRequestModel loginRequestModel ) {
	    log.info("Incoming user login request: {}", loginRequestModel);

	    try {
	    	 loginResponseModel response = service.Login(loginRequestModel);
	        log.info("User logged in successfully: {}", response);
	        return RestResponse.build().withSuccess("Login successful", response);
	    } catch (Exception e) {
	        log.error("Login failed: {}", e.getMessage(), e);
	        return RestResponse.build().withError(e.getMessage());
	    }
	}
	
	@Operation(summary = "Edit user profile deatil if want to .")
	@PutMapping( value = "/EditUser", consumes = "application/json", produces = "application/json")
	public RestResponse userEditProfile (@Valid @RequestBody userEditRequestModel userEditRequestModel ) {
	   
		 log.info("Received request to edit user profile: {}", userEditRequestModel);
	    try {
	    	   log.info("Invoking service to edit user profile for userId: {}", userEditRequestModel.getUserId());
	    	 userResponseModel response = service.userEditProfile(userEditRequestModel);
	        return RestResponse.build().withSuccess("edited succesfully...." ,response);
	    } catch (Exception e) {
	        log.error("Failed to edit profile for userId: {} - Error: {}", userEditRequestModel.getUserId(), e.getMessage(), e);
	        return RestResponse.build().withError(e.getMessage());
	    }
	}
	
	
	@Operation(summary = "you can change status to active and deactivate ", description = "This method deletes a user based on userId")
	@DeleteMapping(value = "/changeStatus", produces = "application/json")
	public RestResponse changeStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
		log.info("changing status for user by userid: {}, status: {} ", id, status);
		try {
			
			userResponseModel responseModel = service.changestatus(id, status);
			
			if (status == 0)
				return RestResponse.build().withSuccess("User re-activated successfully").withData(responseModel);
			else
				return RestResponse.build().withSuccess("User de-activated successfully").withData(responseModel);
		} catch (Exception e) {
			log.error("Failed to delete user due to: {}", e.getMessage(), e);
			return RestResponse.build().withError(e.getMessage());
		}
	}
	
	
	
	

}
