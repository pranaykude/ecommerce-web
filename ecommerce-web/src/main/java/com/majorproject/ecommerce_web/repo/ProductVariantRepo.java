package com.majorproject.ecommerce_web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.majorproject.ecommerce_web.entity.ProductVariant;

public interface ProductVariantRepo extends JpaRepository<ProductVariant, Integer> {

}
