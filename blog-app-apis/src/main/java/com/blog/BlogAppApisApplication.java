package com.blog;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blog.config.AppConstants;
import com.blog.entity.RoleEntity;
import com.blog.repository.RoleRepo;


@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(this.passwordEncoder.encode("gef"));
		
		try {
			RoleEntity roleEntity1 = new RoleEntity();
			roleEntity1.setId(AppConstants.ADMIN_USER);
			roleEntity1.setRoleName("ROLE_ADMIN");
			
			RoleEntity roleEntity2 = new RoleEntity();
			roleEntity2.setId(AppConstants.NORMAL_USER);
			roleEntity2.setRoleName("ROLE_NORMAL");
			
			List<RoleEntity> roles = List.of(roleEntity1, roleEntity2);
			
			List<RoleEntity> result = this.roleRepo.saveAll(roles);
			
			result.forEach(r ->{
				System.out.println(r.getRoleName());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
