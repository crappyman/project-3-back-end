package com.project3.revtech.dao;

import com.project3.revtech.entity.PurchasedItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasedItemRepository extends JpaRepository<PurchasedItemEntity, Integer> {
    List<PurchasedItemEntity> findAllByTransactionId(int transactionId);
    List<PurchasedItemEntity> findAllByUserId(int userId);

}
