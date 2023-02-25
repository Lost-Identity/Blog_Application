package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.CommentEntity;

public interface CommentRepo extends JpaRepository<CommentEntity, Integer> {

}
