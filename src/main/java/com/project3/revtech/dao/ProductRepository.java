package com.project3.revtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project3.revtech.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    //----- Product Custom JPA Queries ----------//
    ProductEntity findByProductId(int productId);

}
