package com.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name = "post_title", length = 100, nullable = false)
	private String postTitle;
	
	@Column(name = "post_content", length = 10000, nullable = false)
	private String postContent;
	
	private String imageName;
	
	private Date addeddate;
	
	@ManyToOne()
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEntity category;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<CommentEntity> comments = new ArrayList<>();
}
