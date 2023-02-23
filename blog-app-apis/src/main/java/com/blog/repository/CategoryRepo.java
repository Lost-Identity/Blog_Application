package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer>{

}
