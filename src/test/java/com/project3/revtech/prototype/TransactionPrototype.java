package com.project3.revtech.prototype;

import com.project3.revtech.entity.TransactionEntity;
import com.project3.revtech.pojo.TransactionPojo;

import java.sql.Timestamp;

public class TransactionPrototype {
    public static TransactionEntity transactionTestObj() {
        TransactionEntity newTransaction = new TransactionEntity(1, new Timestamp(System.currentTimeMillis()), 1);
        return newTransaction;
    }

    public static TransactionPojo transactionPojoTestObj(TransactionEntity testEntity) {
        TransactionPojo newTransactionPojo = new TransactionPojo(testEntity.getTransactionId(), testEntity.getTransactionDate(), testEntity.getCartId());
        return newTransactionPojo;
    }
}
