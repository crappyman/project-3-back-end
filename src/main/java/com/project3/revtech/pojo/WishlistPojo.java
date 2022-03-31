package com.project3.revtech.pojo;
import java.util.Date;

public class WishlistPojo {
	
	private int  wishlistId;
	private int  userId;
	private Date createdDate;
	private int  productId;
	
	public WishlistPojo() {
		super();
	}

	public WishlistPojo(int wishlistId, int userId, Date createdDate, int productId) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.productId = productId;
	}

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "WishlistPojo [wishlistId=" + wishlistId + ", userId=" + userId + ", createdDate=" + createdDate
				+ ", productId=" + productId + "]";
	}
	
	
	
	
	



	

	
	
	
	
	
	
	
	
	

}
