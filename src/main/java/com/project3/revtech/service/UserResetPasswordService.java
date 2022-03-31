package com.project3.revtech.service;

import com.project3.revtech.entity.UserEntity;


public interface UserResetPasswordService {
	 //Set a token to the user that has the email
	 public void updateResetPasswordToken(String token, String email);
	 public void updatePassword(UserEntity user, String newPassword);
	 public UserEntity getByResetPasswordToken(String token);
	 public void sendEmail(String recipientEmail, String link);
}
