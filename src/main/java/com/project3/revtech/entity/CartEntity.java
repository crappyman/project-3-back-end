package com.project3.revtech.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_details")
public class CartEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;

	@OneToOne(mappedBy = "cartEntity")
	private TransactionEntity transactionEntity;

	@Column(name = "user_id")
	private int userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	private UserEntity userEntity;

	@OneToMany(mappedBy = "cartEntity")
	private List<CartItemEntity> cartItems;
	
	@Column(name = "cart_total")
	private int cartTotal;

	@Column(name = "cart_paid")
	private boolean cartPaid;

	@Column(name = "cart_removed")
	private boolean cartRemoved;

	public CartEntity(int cartId, int userId, int cartTotal, boolean cartPaid, boolean cartRemoved) {
		this.cartId = cartId;
		this.userId = userId;
		this.cartTotal = cartTotal;
		this.cartPaid = cartPaid;
		this.cartRemoved = cartRemoved;
	}

	public CartEntity(int userId, int cartTotal, boolean cartPaid, boolean cartRemoved) {
		this.userId = userId;
		this.cartTotal = cartTotal;
		this.cartPaid = cartPaid;
		this.cartRemoved = cartRemoved;
	}

}
