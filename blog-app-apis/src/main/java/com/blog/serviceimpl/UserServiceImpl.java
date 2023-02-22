package com.blog.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.UserEntity;
import com.blog.exception.ResourceNotFoundException;
import com.blog.model.UserDto;
import com.blog.repository.UserRepo;
import com.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity userEntity = this.dtoTOEntity(user);
		UserEntity savedUser = this.userRepo.save(userEntity);
		return this.entityToDto(savedUser);
	}

	@Override
	public UserDto upadateUser(UserDto user, Integer userId) {
		
		UserEntity userEntity = this.userRepo.findById(userId).orElseThrow((()-> new ResourceNotFoundException("User", "Id", userId)));
		
		userEntity.setName(user.getName());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(user.getPassword());
		userEntity.setAbout(user.getAbout());
		
		this.userRepo.save(userEntity);
		UserDto userDto =  this.entityToDto(userEntity);
		return userDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		UserEntity userEntity = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		
		return this.entityToDto(userEntity);
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<UserEntity> userEntities =  this.userRepo.findAll();
		
		List<UserDto> userDtos =  userEntities.stream().map(user -> this.entityToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		UserEntity userEntity =  this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(userEntity);
	}
	
	
	private UserEntity dtoTOEntity(UserDto userDto) {
		
		UserEntity userEntity = this.modelMapper.map(userDto, UserEntity.class);
		
//		userEntity.setId(user.getId());
//		userEntity.setName(user.getName());
//		userEntity.setEmail(user.getEmail());
//		userEntity.setPassword(user.getPassword());
//		userEntity.setAbout(user.getAbout());
		
		return userEntity;
		
	}
	
	private UserDto entityToDto(UserEntity userEntity) {
			
			UserDto userDto = this.modelMapper.map(userEntity, UserDto.class);
			
//			userDto.setId(user.getId());
//			userDto.setName(user.getName());
//			userDto.setEmail(user.getEmail());
//			userDto.setPassword(user.getPassword());
//			userDto.setAbout(user.getAbout());
			
			return userDto;
			
	}

}
