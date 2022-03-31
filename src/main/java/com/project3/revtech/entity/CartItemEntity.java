package com.project3.revtech.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_item_id")
	private int cartItemId;

	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "product_id")
	private int productId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	private ProductEntity productEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id", nullable = false, insertable = false, updatable = false)
	private CartEntity cartEntity;

	@Column(name = "cart_qty")
	private int cartQty;

	public CartItemEntity(int cartItemId, int cartId, int productId, int cartQty) {
		this.cartItemId = cartItemId;
		this.cartId = cartId;
		this.productId = productId;
		this.cartQty = cartQty;
	}
	public CartItemEntity( int cartId, int productId, int cartQty) {
		this.cartId = cartId;
		this.productId = productId;
		this.cartQty = cartQty;
	}

}
