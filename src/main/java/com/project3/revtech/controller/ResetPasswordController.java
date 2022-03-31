package com.project3.revtech.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project3.revtech.pojo.ResetPasswordPojo;
import com.project3.revtech.service.UserResetPasswordService;

import net.bytebuddy.utility.RandomString;



@CrossOrigin
@RestController
@RequestMapping("/reset")
public class ResetPasswordController {
	@Autowired
	UserResetPasswordService resetPasswordService;
	 @PostMapping("forgot_password")
	    void processForgotPassword(@RequestBody ResetPasswordPojo resetObject) {
		 
		 String token = RandomString.make(30);
		 resetPasswordService.updateResetPasswordToken(token, resetObject.getEmail());
		 

	    }
	 
}
