package com.project3.revtech.joinedpojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemProductDiscountPojo {
    private int cartItemId;
    private int cartId;
    private int productId;
    private int cartQty;
    private ProductAndDiscountPojo productAndDiscount;

}
