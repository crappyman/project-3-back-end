package com.project3.revtech.dao;

import com.project3.revtech.entity.DiscountEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Integer> {
    DiscountEntity findByDiscountId(int discountId);
}

