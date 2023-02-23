package com.blog.service;

import java.util.List;

import com.blog.model.CategoryDto;

public interface CategoryService {
	
	// create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	// get
	public CategoryDto getSingleCategory(Integer categoryId);
	
	//getAll
	public List<CategoryDto> getAllCategory();

}
