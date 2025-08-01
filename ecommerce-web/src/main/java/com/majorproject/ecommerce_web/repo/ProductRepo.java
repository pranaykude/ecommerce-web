package com.majorproject.ecommerce_web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.majorproject.ecommerce_web.entity.Product;



public interface ProductRepo  extends JpaRepository< Product, Integer> {

}
