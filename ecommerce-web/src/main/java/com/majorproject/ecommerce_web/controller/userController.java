package com.majorproject.ecommerce_web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.amstech.student.response.RestResponse;
import com.majorproject.ecommerce_web.requestmodel.userSignupRequestModel;
import com.majorproject.ecommerce_web.responsemodel.userResponseModel;
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
	@RequestMapping(method =RequestMethod.POST, value="/Register"  ,  consumes="application/json" ,  produces="application/json" )
	public RestResponse Register(@Valid @RequestBody userSignupRequestModel userSignupRequestModel) {	
        log.info(" Incoming user signup request: {}", userSignupRequestModel);
	   try {
		   userResponseModel responseModel = service.Register(userSignupRequestModel);
           log.info(" User registered successfully: {}", responseModel);
		   return RestResponse.build().withSuccess("user resgistred succesfully ",responseModel);
  	   }
	    catch (Exception e) {
          log.error(" Failed to register user: {}", e.getMessage(), e);
		  return RestResponse.build().withError(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	

}
