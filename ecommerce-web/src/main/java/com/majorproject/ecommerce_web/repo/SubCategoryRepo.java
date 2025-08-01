package com.majorproject.ecommerce_web.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.majorproject.ecommerce_web.entity.Subcategory;

public interface SubCategoryRepo extends JpaRepository< Subcategory, Integer> {

	
	@Query("SELECT s FROM Subcategory s WHERE s.subcategoryId = :id AND s.isDeleted = 0")
	Optional<Subcategory> findActiveById(@Param("id") Integer id);
	
}
