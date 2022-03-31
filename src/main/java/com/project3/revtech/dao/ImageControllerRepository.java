package com.project3.revtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project3.revtech.entity.ImageEntity;

public interface ImageControllerRepository extends JpaRepository<ImageEntity, Integer> {

}
