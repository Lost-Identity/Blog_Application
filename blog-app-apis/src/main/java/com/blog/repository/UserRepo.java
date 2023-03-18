package com.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
	
	Optional<UserEntity> findByEmail(String email);

}
