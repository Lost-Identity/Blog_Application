package com.blog.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class RoleEntity {
	
	@Id
	private Integer id;
	
	private String roleName;
	
	

}
