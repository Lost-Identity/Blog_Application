package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.CategoryEntity;
import com.blog.entity.PostEntity;
import com.blog.entity.UserEntity;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {
	
	
	List<PostEntity> findByUser(UserEntity userEntity);

	List<PostEntity> findByCategory(CategoryEntity categoryEntity);
}
