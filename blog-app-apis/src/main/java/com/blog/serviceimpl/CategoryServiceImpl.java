package com.blog.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.CategoryEntity;
import com.blog.exception.ResourceNotFoundException;
import com.blog.model.CategoryDto;
import com.blog.repository.CategoryRepo;
import com.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		CategoryEntity categoryEntity = this.modelMapper.map(categoryDto, CategoryEntity.class);
		
		CategoryEntity addedCategory = this.categoryRepo.save(categoryEntity);
		
		return this.modelMapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		CategoryEntity categoryEntity = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		categoryEntity.setCategoryTitle(categoryDto.getCategoryTitle());
		categoryEntity.setCategoryDescription(categoryDto.getCategoryDescription());
		
		CategoryEntity updatedCategory = this.categoryRepo.save(categoryEntity);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		CategoryEntity categoryEntity = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));
		
		this.categoryRepo.delete(categoryEntity);
	}

	@Override
	public CategoryDto getSingleCategory(Integer categoryId) {
		
		CategoryEntity categoryEntity = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));
		
		return this.modelMapper.map(categoryEntity, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		
		List<CategoryEntity> categoryEntities = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos = categoryEntities.stream().map((category) -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return categoryDtos;
				
	}

}
