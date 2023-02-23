package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.ApiResponse;
import com.blog.model.PostDto;
import com.blog.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
		
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}
	
	//get posts by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		
		List<PostDto> postsByUser = this.postService.getPostsByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);
	}
	
	//get posts by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		
		List<PostDto> postsByCategory = this.postService.getPostsByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(postsByCategory, HttpStatus.OK);
	}
	
	//get all posts
	@GetMapping("/posts/")
	public ResponseEntity<List<PostDto>> getAllPosts(){
		
		List<PostDto> postDtos = this.postService.getAllPost();
		
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}
	
	//get post by id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		
		PostDto postDto = this.postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}
	
	//delete post by id
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePostById(@PathVariable Integer postId){
		
		this.postService.deletePost(postId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted Successfully !!", true), HttpStatus.OK);
	}
	
	//update post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
		
		PostDto updatedPostDto = this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(updatedPostDto, HttpStatus.OK);
		
	}

}