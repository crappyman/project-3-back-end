package com.project3.revtech.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") 
})
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@NotBlank
	@Size(max = 20)
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Size(max = 20)
	@Column(name="last_name")
	private String lastName;

	@NotBlank
	@Size(max = 200)
	private String address;

	@NotBlank
	@Size(min = 10)
	private String contact;

	@OneToMany(mappedBy = "productEntity")
	private List<ReviewEntity> reviews;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(  name = "user_roles", 
	joinColumns = @JoinColumn(name = "uid"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleEntity> roles = new HashSet<>();

	public UserEntity(String username, String email, String password, String first_name, String last_name, String address, String contact) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = first_name;
		this.lastName = last_name;
		this.address = address;
		this.contact = contact;

	}

}
