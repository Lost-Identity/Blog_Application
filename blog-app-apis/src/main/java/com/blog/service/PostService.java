package com.blog.service;

import java.util.List;


import com.blog.model.PostDto;
import com.blog.model.PostResponseDto;

public interface PostService {
	
	//create
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	public PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	public void deletePost(Integer postId);
	
	//get all posts
	public PostResponseDto getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//get single post
	public PostDto getPostById(Integer postId);
	
	//get all post by category
	public PostResponseDto getPostsByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);
	
	//get all posts by user
	public PostResponseDto getPostsByUser(Integer userId, Integer pageNumber, Integer pageSize);
	
	//get posts
	public List<PostDto> searchPost(String keyword);

}
