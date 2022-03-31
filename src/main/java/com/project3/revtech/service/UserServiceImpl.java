package com.project3.revtech.service;

import javax.transaction.Transactional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.project3.revtech.dao.UserRepository;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.UserPojo;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	  PasswordEncoder encoder;
	@Autowired
	UserRepository 	userRepositoryDao ;
	
	 public UserServiceImpl() {}
	
	@Override
	public UserPojo updateUserService(UserPojo userInfo) throws ApplicationException {
	
//		 User updateUser = new User(userInfo.getUser_id(), userInfo.getUsername(), encoder.encode(userInfo.getPassword()), userInfo.getEmail(), userInfo.getFirstName(), userInfo.getLastName(),
//				                    userInfo.getAddress(), userInfo.getContact());
//		User  returnUser = userRepositoryDao.save(updateUser);
				
		return userInfo;
}
	@Override
	public UserPojo getAUserService(int user_id) throws ApplicationException{
		 UserPojo userPojo = null;
	        Optional<UserEntity> optional = this.userRepositoryDao.findById(user_id);
	        if (optional.isPresent()) {
	            UserEntity user = optional.get();
	            userPojo = new  UserPojo(user.getUserId(), user.getUsername(), encoder.encode(user.getPassword()), user.getEmail(), user.getFirstName(), user.getLastName(),
	                    user.getAddress(), user.getContact());
	        }
	        return  userPojo;
	}
}