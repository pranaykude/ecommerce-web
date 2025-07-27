package com.majorproject.ecommerce_web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.majorproject.ecommerce_web.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
