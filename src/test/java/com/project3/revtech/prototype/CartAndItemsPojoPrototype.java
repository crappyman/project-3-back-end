package com.project3.revtech.prototype;

import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.CartItemEntity;
import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.joinedpojo.CartAndItemsPojo;
import com.project3.revtech.joinedpojo.ItemProductDiscountPojo;
import com.project3.revtech.joinedpojo.ProductAndDiscountPojo;
import com.project3.revtech.pojo.CartPojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartAndItemsPojoPrototype {
    public static CartAndItemsPojo cartAndItemsTestObj() {
        List<ItemProductDiscountPojo> cartItems = itemProductDiscountPojoTestList();
        CartEntity cartEntity = cartTestObj();
        return new CartAndItemsPojo(cartEntity.getCartId(), cartEntity.getUserId(), cartEntity.getCartTotal(), cartEntity.isCartPaid(), cartEntity.isCartRemoved(), cartItems);
    }

    public static CartEntity cartTestObj() {
        CartEntity cart = new CartEntity(1, 1, 100, false, false);
        cart.setCartItems(cartItemTestList());
        return cart;
    }

    public static CartPojo cartPojoTestObj() {
        CartEntity cartEntity = cartTestObj();
        return new CartPojo(cartEntity.getCartId(), cartEntity.getUserId(), cartEntity.getCartTotal(), cartEntity.isCartPaid(), cartEntity.isCartRemoved());
    }

    public static List<CartItemEntity> cartItemTestList() {
        List <CartItemEntity> items = new ArrayList<CartItemEntity>();
        items.add(cartItemTestObj());
        return items;
    }


    public static CartItemEntity cartItemTestObj() {
        CartItemEntity item = new CartItemEntity(1, 1, 1, 3);
        item.setProductEntity(productTestObj());
        return item;
    }

    public static ProductEntity productTestObj() {
        ProductEntity product = new ProductEntity(  1, "12345", "iphone",
                                        new BigDecimal("25.05"), "phones",
                                        "String productDescription", 5,
                                        "String imageUrl", false
        );
        product.setDiscountEntity(discountTestObj());
        return product;
    }

    public static DiscountEntity discountTestObj() {
        return new DiscountEntity(1, 1, " discountDescription", new BigDecimal("20.00"));
    }

    public static ProductAndDiscountPojo productAndDiscountPojoTestObj() {
        ProductEntity testProduct = productTestObj();
        DiscountEntity testDiscount = discountTestObj();
        return new ProductAndDiscountPojo(  testProduct.getProductId(), testProduct.getProductSku(), testProduct.getProductName(),
                                            testProduct.getProductCost(), testProduct.getProductCategory(), testProduct.getProductDescription(),
                                            testProduct.getProductQty(), testProduct.getImageUrl(), testProduct.isProductRemoved(),
                                            testDiscount.getDiscountId(), testDiscount.getDiscountDescription(), testDiscount.getDiscountPercentage()
        );
    }

    public static ItemProductDiscountPojo itemProductDiscountPojoTestObj() {
        CartItemEntity tempItem = cartItemTestObj();
        ProductEntity tempProduct = productTestObj();
        DiscountEntity tempDiscount = discountTestObj();
        ProductAndDiscountPojo tempPAD = new ProductAndDiscountPojo(tempProduct.getProductId(), tempProduct.getProductSku(),
                tempProduct.getProductName(), tempProduct.getProductCost(), tempProduct.getProductCategory(),
                tempProduct.getProductDescription(), tempProduct.getProductQty(), tempProduct.getImageUrl(),
                tempProduct.isProductRemoved(), tempDiscount.getDiscountId(), tempDiscount.getDiscountDescription(),
                tempDiscount.getDiscountPercentage()
        );
        return new ItemProductDiscountPojo(tempItem.getCartItemId(), tempItem.getCartId(), tempItem.getProductId(), tempItem.getCartQty(), tempPAD);
    }

    public static List<ItemProductDiscountPojo> itemProductDiscountPojoTestList() {
        List<ItemProductDiscountPojo> items = new ArrayList<ItemProductDiscountPojo>();
        items.add(itemProductDiscountPojoTestObj());
        return items;
    }


}
