package com.project3.revtech.entity;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "product_id")
    private int productId;

    @CreatedDate
    @Column(name = "date")
    private Date date;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private int rating;

    @Column(name = "review")
    private String review;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    private ProductEntity productEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private UserEntity userEntity;

    public ReviewEntity(int reviewId, int userId, int productId, Date date, String title, int rating, String review) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.productId = productId;
        this.date = date;
        this.title = title;
        this.rating = rating;
        this.review = review;
    }

    public ReviewEntity(int userId, int productId, Date date, String title, int rating, String review) {
        this.userId = userId;
        this.productId = productId;
        this.date = date;
        this.title = title;
        this.rating = rating;
        this.review = review;
    }

    public ReviewEntity(int userId, int productId, String title, int rating, String review) {
        this.userId = userId;
        this.productId = productId;
        this.title = title;
        this.rating = rating;
        this.review = review;
    }

}
