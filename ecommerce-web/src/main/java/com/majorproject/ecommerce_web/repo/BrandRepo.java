package com.majorproject.ecommerce_web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.majorproject.ecommerce_web.entity.Brand;

public interface BrandRepo  extends JpaRepository<Brand, Integer>{

	   Brand findByName(String name);
}
