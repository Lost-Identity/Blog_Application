package com.blog.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.CommentEntity;
import com.blog.entity.PostEntity;
import com.blog.entity.UserEntity;
import com.blog.exception.ResourceNotFoundException;
import com.blog.model.CommentDto;
import com.blog.model.UserDto;
import com.blog.repository.CommentRepo;
import com.blog.repository.PostRepo;
import com.blog.repository.UserRepo;
import com.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {
		
		UserEntity userEntity = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		
		UserDto userDto = this.modelMapper.map(userEntity, UserDto.class);
		
		PostEntity postEntity = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));
		
		CommentEntity commentEntity = this.modelMapper.map(commentDto, CommentEntity.class);
		
		commentEntity.setUser(userEntity);
		commentEntity.setPost(postEntity);
		commentEntity.setUser(userEntity);
		
		this.commentRepo.save(commentEntity);
		return this.modelMapper.map(commentEntity, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		CommentEntity commentEntity = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "commentId", commentId));
		
		this.commentRepo.delete(commentEntity);
	}

}
