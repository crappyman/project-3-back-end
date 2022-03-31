package com.project3.revtech.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project3.revtech.dao.ResetPasswordEntityRepository;
import com.project3.revtech.dao.UserRepository;
import com.project3.revtech.entity.ResetPasswordEntity;
import com.project3.revtech.entity.UserEntity;

@Service
@Transactional
public class UserResetPasswordServiceImpl implements UserResetPasswordService {

	@Autowired
	  UserRepository userRepository;
	@Autowired
	ResetPasswordEntityRepository resetRepository;
	//The password encoder that is used in the UserServiceImpl
	@Autowired
	  PasswordEncoder encoder;
	
	@Override
	public void updateResetPasswordToken(String token, String email) {
		// TODO Auto-generated method stub
		
        UserEntity user = userRepository.findByEmail(email);
        if (user != null) {
        	ResetPasswordEntity resetPasswordEntity = new ResetPasswordEntity();
        	resetPasswordEntity.setUser(user);
        	resetPasswordEntity.setResetPasswordToken(token);
        	resetRepository.save(resetPasswordEntity);
        } 
        
        //TODO: ADD the exception later
	}

	@Override
	public void updatePassword(UserEntity user, String newPassword) {

		
        String encodedPassword = encoder.encode(newPassword);
        user.setPassword(encodedPassword);
        
        ResetPasswordEntity resetPasswordEntity = resetRepository.findByUser(user);
        resetPasswordEntity.setResetPasswordToken(null);
        resetRepository.save(resetPasswordEntity);
	}

	@Override
	public UserEntity getByResetPasswordToken(String token) {
		// TODO Auto-generated method stub
		
		return resetRepository.findByResetPasswordToken(token).getUser();
	}

	@Override
	public void sendEmail(String recipientEmail, String link) {
		// TODO Auto-generated method stub
		
		//To be completed by the one that is going to work with the email
		String subject = "Here's the link to reset your password";
	     
	    String content = "<p>Hello,</p>"
	            + "<p>You have requested to reset your password.</p>"
	            + "<p>Click the link below to change your password:</p>"
	            + "<p><a href=\"" + link + "\">Change my password</a></p>"
	            + "<br>"
	            + "<p>Ignore this email if you do remember your password, "
	            + "or you have not made the request.</p>";
	    //To be completed by the one that is going to work by email
	     
	}

}
