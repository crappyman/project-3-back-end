package com.project3.revtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project3.revtech.entity.ResetPasswordEntity;
import com.project3.revtech.entity.UserEntity;

public interface ResetPasswordEntityRepository  extends JpaRepository<ResetPasswordEntity, Integer> {
		ResetPasswordEntity findByResetPasswordToken(String token);
		@Query("from ResetPasswordEntity r where r.user.email =:email")
		ResetPasswordEntity findByUserEmail(String email);
}
