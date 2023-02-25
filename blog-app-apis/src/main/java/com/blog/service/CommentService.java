package com.blog.service;

import com.blog.model.CommentDto;

public interface CommentService {
	
	//create
	public CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId);
	
	
	//delete
	public void deleteComment(Integer commentId);
	
	

}
