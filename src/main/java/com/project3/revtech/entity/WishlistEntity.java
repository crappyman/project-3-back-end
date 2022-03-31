package com.project3.revtech.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "wish_list_details")
public class WishlistEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_id")
	private int  wishlistId;
	
	@NotNull
	@Column(name = "user_id")
	private int  userId;
	
	@NotNull
	@Column(name = "created_date")
	@CreatedDate
	private Date createdDate;
	
	@NotNull
	@Column(name = "product_id")
	private int  productId;
	
	  //Object of product entity to store the product information
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity productEntity;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userEntity;
	
	
	
	public WishlistEntity(int wishlistId, int userId, Date createdDate, int productId) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.productId = productId;
	}
	
	
	
	
    public WishlistEntity(int userId, int productId) {
        this.userId = userId;
        this.productId=productId;
        //storing the current data & time in created_date column
        this.createdDate = new Date();
    }


	
	
	
	


}
