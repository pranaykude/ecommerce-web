package com.majorproject.ecommerce_web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.majorproject.ecommerce_web.entity.ProductImage;



public interface ProductImageRepo extends JpaRepository< ProductImage, Integer> {

}
