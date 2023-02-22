package com.blog.service;

import java.util.List;

import com.blog.model.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto upadateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer userId);

}
