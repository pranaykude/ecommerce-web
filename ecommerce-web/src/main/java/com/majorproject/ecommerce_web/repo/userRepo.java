package com.majorproject.ecommerce_web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.majorproject.ecommerce_web.entity.User;

public interface userRepo extends JpaRepository<User, Integer> {

	@Query("SELECT e From User e WHERE e.email =:email ")
		User findbyEmail(@Param("email")String email);
	
	@Query("SELECT e From User e WHERE e.mobileNumber =:mobileNumber  ")
	User findbyMobileNumber(@Param("mobileNumber")String mobileNumber);
	
	@Query("SELECT e FROM User e WHERE e.email = :email AND e.password = :password")
	User login(@Param("email") String email, @Param("password") String password);

	
	
	
	
}

