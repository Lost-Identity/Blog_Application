package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

}
