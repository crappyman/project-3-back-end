package com.project3.revtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project3.revtech.entity.ResetPasswordEntity;
import com.project3.revtech.entity.UserEntity;

public interface ResetPasswordEntityRepository  extends JpaRepository<ResetPasswordEntity, Integer> {
		ResetPasswordEntity findByResetPasswordToken(String token);
		ResetPasswordEntity findByUser(UserEntity user);
}
