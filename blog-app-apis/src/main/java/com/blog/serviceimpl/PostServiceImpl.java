package com.blog.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.CategoryEntity;
import com.blog.entity.PostEntity;
import com.blog.entity.UserEntity;
import com.blog.exception.ResourceNotFoundException;
import com.blog.model.PostDto;
import com.blog.repository.CategoryRepo;
import com.blog.repository.PostRepo;
import com.blog.repository.UserRepo;
import com.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId, Integer categoryId) {
		
		UserEntity userEntity = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		CategoryEntity categoryEntity = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
		
		PostEntity postEntity = this.modelMapper.map(postDto, PostEntity.class);
		postEntity.setImageName("default.png");
		postEntity.setAddeddate(new Date());
		postEntity.setUser(userEntity);
		postEntity.setCategory(categoryEntity);
		
		PostEntity createPost = this.postRepo.save(postEntity);
		
		return this.modelMapper.map(createPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
//		UserEntity userEntity = this.userRepo.findById(postDto.getUser().getId()).orElseThrow(() -> new ResourceNotFoundException("user", "userId", postDto.getUser().getId()));
//		CategoryEntity categoryEntity = this.categoryRepo.findById(postDto.getCategory().getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("category", "catgoryId", postDto.getCategory().getCategoryId()));
		
		PostEntity postEntity = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "Postid", postId));
		
		postEntity.setPostTitle(postDto.getPostTitle());
		postEntity.setPostContent(postDto.getPostContent());
		postEntity.setImageName(postDto.getImageName());
		postEntity.setAddeddate(new Date());
//		postEntity.setCategory(categoryEntity);
//		postEntity.setUser(userEntity);
		
		PostEntity updatePost = this.postRepo.save(postEntity);
		
		return this.modelMapper.map(updatePost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		
		PostEntity postEntity = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));
		
		this.postRepo.delete(postEntity);

	}

	@Override
	public List<PostDto> getAllPost() {
		
		List<PostEntity> postEntities = this.postRepo.findAll();
		List<PostDto> postDtos = postEntities.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		PostEntity postEntity = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));
		
		PostDto postDto = this.modelMapper.map(postEntity, PostDto.class);
		
		return postDto;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		CategoryEntity categoryEntity = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "categoryId" , categoryId));
		
		List<PostEntity> postEntities = this.postRepo.findByCategory(categoryEntity);
		List<PostDto> postDtos = postEntities.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		
		UserEntity userEntity = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		
		List<PostEntity> postEntities = this.postRepo.findByUser(userEntity);
		List<PostDto> postDtos = postEntities.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
