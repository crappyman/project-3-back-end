package com.project3.revtech.entity;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchased_items")
public class PurchasedItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "item_qty")
    private int itemQty;

    @Column(name = "purchase_cost")
    private BigDecimal purchaseCost;

    @CreatedDate
    @Column(name = "purchase_date")
    private Date purchaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false, insertable = false, updatable = false)
    private TransactionEntity transactionEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    private ProductEntity productEntity;

    public PurchasedItemEntity(int itemId, int transactionId, int userId, int cartId, int productId, int itemQty, BigDecimal purchaseCost, Date purchaseDate) {
        this.itemId = itemId;
        this.transactionId = transactionId;
        this.userId = userId;
        this.cartId = cartId;
        this.productId = productId;
        this.itemQty = itemQty;
        this.purchaseCost = purchaseCost;
        this.purchaseDate = purchaseDate;
    }

    public PurchasedItemEntity(int transactionId, int userId, int cartId, int productId, int itemQty, BigDecimal purchaseCost, Date purchaseDate) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.cartId = cartId;
        this.productId = productId;
        this.itemQty = itemQty;
        this.purchaseCost = purchaseCost;
        this.purchaseDate = purchaseDate;
    }

    public PurchasedItemEntity(int transactionId, int userId, int cartId, int productId, int itemQty, BigDecimal purchaseCost) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.cartId = cartId;
        this.productId = productId;
        this.itemQty = itemQty;
        this.purchaseCost = purchaseCost;
    }

}
