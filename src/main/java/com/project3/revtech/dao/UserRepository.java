package com.project3.revtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.project3.revtech.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	Optional<UserEntity> findByUsername(String username);
	
	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
	  //Return the user that matches that email.
	  UserEntity findByEmail(String email);
}
