package com.blog.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	
	private Integer categoryId;
	
//	@NotEmpty
	@Size(min = 4, message = "Title must be minimum of 4 characters !!")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min = 10, message = "Description must be minimum of 10 characters !!")
	private String categoryDescription;

}
