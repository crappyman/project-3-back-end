package com.project3.revtech.service;

import com.project3.revtech.dao.CartRepository;
import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.CartItemEntity;
import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.joinedpojo.CartAndItemsPojo;
import com.project3.revtech.joinedpojo.ItemProductDiscountPojo;
import com.project3.revtech.joinedpojo.ProductAndDiscountPojo;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartItemProductServiceImpl implements CartItemProductService {

    @Autowired
    CartRepository cartRepository;

    @Autowired CartServiceImpl cartService;


        @Override
    public CartAndItemsPojo getAllCartItemProducts(int cartId) {

        CartEntity cartEntity = cartRepository.getById(cartId);
            return getCartAndItemsPojo(cartEntity);
        }

    @Override
    public CartAndItemsPojo getAllCartItemProductsForUser(int userId) {
        CartEntity cartEntity = cartRepository.findByUserIdAndCartRemovedFalseAndCartPaidFalse(userId);
        if (cartEntity == null) {
            cartEntity = new CartEntity(userId, 0, false, false);
            cartEntity = cartRepository.saveAndFlush(cartEntity);
        }
        return getCartAndItemsPojo(cartEntity);
    }

    @NotNull
    private CartAndItemsPojo getCartAndItemsPojo(CartEntity cartEntity) {
        List<CartItemEntity> cartItems = cartEntity.getCartItems() == null ? new ArrayList<CartItemEntity>(): cartEntity.getCartItems();
        List<ItemProductDiscountPojo> joinedDataItems = new ArrayList<ItemProductDiscountPojo>();
        for (CartItemEntity tempItem : cartItems) {
            ProductEntity tempProduct = tempItem.getProductEntity();
            DiscountEntity tempDiscount = (tempProduct.getDiscountEntity() == null ? new DiscountEntity(true) : tempProduct.getDiscountEntity());

            ProductAndDiscountPojo tempPAD = new ProductAndDiscountPojo(tempProduct.getProductId(), tempProduct.getProductSku(),
                    tempProduct.getProductName(), tempProduct.getProductCost(), tempProduct.getProductCategory(),
                    tempProduct.getProductDescription(), tempProduct.getProductQty(), tempProduct.getImageUrl(),
                    tempProduct.isProductRemoved(), tempDiscount.getDiscountId(), tempDiscount.getDiscountDescription(),
                    tempDiscount.getDiscountPercentage()
            );

            ItemProductDiscountPojo tempIPD = new ItemProductDiscountPojo(tempItem.getCartItemId(), tempItem.getCartId(), tempItem.getProductId(), tempItem.getCartQty(), tempPAD);
            joinedDataItems.add(tempIPD);
        }
        return new CartAndItemsPojo(cartEntity.getCartId(), cartEntity.getUserId(), cartEntity.getCartTotal(), cartEntity.isCartPaid(), cartEntity.isCartRemoved(), joinedDataItems);
    }
}
