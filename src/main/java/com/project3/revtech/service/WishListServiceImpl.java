package com.project3.revtech.service;

import java.util.List;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.WishlistPojo;

public class WishListServiceImpl implements WishListService {

	@Override
	public WishlistPojo updateWishList(WishlistPojo wishlistPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPojo getWishListItem(int productId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeProduct(int productId) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WishlistPojo addWishList(WishlistPojo wishlistPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WishlistPojo getWishList(int wishlistId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WishlistPojo getWishListByUserId(int userId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeWishList(WishlistPojo wishListPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductPojo addProduct(ProductPojo productPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPojo updateProduct(ProductPojo productPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductPojo> getAllItemsOfWishlist(int wishlistId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkIfExistsInCart(int wishlistId, int productId) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkIfNoQty(int wishlistId, int productId) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	//@Override
	//public void createWishList(WishlistPojo wishlistPojo) {
		// TODO Auto-generated method stub
		
//	}

	//@Override
	//public List<WishlistPojo> readWishList(int userId) {
		// TODO Auto-generated method stub
		//return null;
	//}

	

}
