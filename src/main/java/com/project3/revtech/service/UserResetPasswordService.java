package com.project3.revtech.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.exception.ResetPasswordException;
import com.project3.revtech.pojo.UserPojo;


public interface UserResetPasswordService {
	 //Set a token to the user that has the email
	 public void updateResetPasswordToken(String token, String email) throws ResetPasswordException;
	 public UserEntity updatePassword(Integer userId, String newPassword);
	 public UserPojo getByResetPasswordToken(String token);
	 public void sendEmail(String recipientEmail, String link) throws UnsupportedEncodingException, MessagingException;
}
