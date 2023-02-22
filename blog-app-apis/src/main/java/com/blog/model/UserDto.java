package com.blog.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
//	@NotEmpty
	@Size(min = 4, message = "Username must be minimum of 4 characters !!")
	private String name;
	
	@Email(message = "Email address is not valid")
	private String email;
	
//	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be minimum of 3 character and maximum of 10 characters !!")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$")
	private String password;
	
	@NotEmpty
	private String about;
}
