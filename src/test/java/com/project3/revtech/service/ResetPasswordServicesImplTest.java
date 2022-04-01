package com.project3.revtech.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project3.revtech.dao.ResetPasswordEntityRepository;
import com.project3.revtech.dao.UserRepository;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.pojo.UserPojo;

@ContextConfiguration(classes = {UserResetPasswordServiceImpl.class})
@ExtendWith(SpringExtension.class)

public class ResetPasswordServicesImplTest {
@MockBean
ResetPasswordEntityRepository resetPasswordEntityRepository;
@MockBean
UserRepository userRepository;
@Autowired
UserResetPasswordServiceImpl userResetPasswordServiceImpl;
@Test
void updateResetPasswordToken () {
	UserEntity userEntity=new UserEntity();
	
	userEntity.setAddress("42 Main St");
	userEntity.setContact("Contact");
	userEntity.setEmail("jane.doe@example.org");
	userEntity.setFirstName("Jane");
	userEntity.setLastName("Doe");
	userEntity.setPassword("iloveyou");
	userEntity.setRoles(new HashSet<>());
	userEntity.setUserId(1);
	userEntity.setUsername("janedoe");
 
	when(this.userRepository.findByEmail("jane.doe@example.org")).thenReturn(userEntity);
	 
	//void actualResult =this.userResetPasswordServiceImpl.updateResetPasswordToken(any(), any());
	verify(this.userRepository.findByEmail("jane.doe@example.org"));
}
}
