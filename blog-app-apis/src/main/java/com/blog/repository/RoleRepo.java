package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.RoleEntity;

public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {

}
