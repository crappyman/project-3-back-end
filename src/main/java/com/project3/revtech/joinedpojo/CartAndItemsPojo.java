package com.project3.revtech.joinedpojo;

import java.util.List;

import lombok.Data;

@Data
public class CartAndItemsPojo {
	private int cartId;
	private int userId;
	private int cartTotal;
	private boolean cartPaid;
	private boolean cartRemoved;
	private List<ItemProductDiscountPojo> cartItems;

	public CartAndItemsPojo(int cartId, int userId, int cartTotal, boolean cartPaid, boolean cartRemoved, List<ItemProductDiscountPojo> cartItems) {
		this.cartId = cartId;
		this.userId = userId;
		this.cartTotal = cartTotal;
		this.cartPaid = cartPaid;
		this.cartRemoved = cartRemoved;
		this.cartItems = cartItems;
	}

}
