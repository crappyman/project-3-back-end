package com.project3.revtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project3.revtech.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Integer> {
    CartEntity findByCartId(int cartId);
    CartEntity findByCartIdAndCartRemovedFalseAndCartPaidFalse(int cartId);
    CartEntity findByUserIdAndCartRemovedFalseAndCartPaidFalse(int userId);
    CartEntity findByUserId(int userId);
    CartEntity findByCartTotalEquals(int cartTotal);

}
