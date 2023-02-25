package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.ApiResponse;
import com.blog.model.CommentDto;
import com.blog.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	
	@Autowired
	private CommentService commentService;
	
	
	//create
	@PostMapping("user/{userId}/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
			@PathVariable Integer userId,
			 @PathVariable Integer postId){
		
		CommentDto createdCommentDto = this.commentService.createComment(commentDto, postId, userId);
		
		return new ResponseEntity<CommentDto>(createdCommentDto, HttpStatus.CREATED);
		
	}
	
	//delete
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		
		this.commentService.deleteComment(commentId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted Successfully !!", true), HttpStatus.OK);
	}
	

}
