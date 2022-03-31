package com.project3.revtech.service;

import java.util.List;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.WishlistPojo;

public interface WishListService {
	
	   WishlistPojo addWishList(WishlistPojo wishlistPojo) throws ApplicationException;
	   
	   WishlistPojo updateWishList(WishlistPojo wishlistPojo) throws ApplicationException;
	   
	   WishlistPojo getWishList(int wishlistId) throws ApplicationException;
	   
	   WishlistPojo getWishListByUserId(int userId) throws ApplicationException;
	   
	   boolean removeWishList(WishlistPojo wishListPojo) throws ApplicationException;
	    
	   ProductPojo addProduct(ProductPojo productPojo) throws ApplicationException;
	    
	   ProductPojo updateProduct(ProductPojo productPojo) throws ApplicationException;
	    
	   ProductPojo getWishListItem(int productId) throws ApplicationException;
	    
	   List<ProductPojo> getAllItemsOfWishlist(int wishlistId) throws ApplicationException;
	    
	   boolean removeProduct(int productId) throws ApplicationException;
	    
	   boolean checkIfExistsInCart(int wishlistId, int productId) throws ApplicationException;
	    
	   boolean checkIfNoQty(int wishlistId, int productId) throws ApplicationException;

}
