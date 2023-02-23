package com.blog.service;

import java.util.List;


import com.blog.model.PostDto;

public interface PostService {
	
	//create
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	public PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	public void deletePost(Integer postId);
	
	//get all posts
	public List<PostDto> getAllPost();
	
	//get single post
	public PostDto getPostById(Integer postId);
	
	//get all post by category
	public List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	public List<PostDto> getPostsByUser(Integer userId);
	
	//get post by wild card
	public List<PostDto> searchPost(String keyword);

}
