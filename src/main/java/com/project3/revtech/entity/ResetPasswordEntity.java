package com.project3.revtech.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reset_password_table")
public class ResetPasswordEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reset_id")
	private int resetId;
	
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;
	
    @Column(name = "reset_password_token")
    private String resetPasswordToken;

        
    
}