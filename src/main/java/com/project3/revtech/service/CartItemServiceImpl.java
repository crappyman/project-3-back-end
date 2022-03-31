package com.project3.revtech.service;

import com.project3.revtech.dao.CartItemRepository;
import com.project3.revtech.entity.CartItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.CartItemPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public CartItemPojo addItem(CartItemPojo item) throws ApplicationException {
        if(item.getCartQty() < 1) {
            item.setCartItemId(-1);
            return item;
        }
        if(this.checkIfExistsInCart(item.getCartId(), item.getProductId())) {
            CartItemEntity existingItem = cartItemRepository.findByCartIdAndProductId(item.getCartId(), item.getProductId());
            item.setCartItemId(existingItem.getCartItemId());
            return this.updateItem(item);
        } else {
            CartItemEntity itemEntity = new CartItemEntity( item.getCartId(), item.getProductId(), item.getCartQty());
            CartItemEntity returningItem = cartItemRepository.saveAndFlush(itemEntity);
            item.setCartItemId(returningItem.getCartItemId());
        }
        return item;
    }

    @Override
    public CartItemPojo updateItem(CartItemPojo item) throws ApplicationException {
        CartItemEntity existingItem = cartItemRepository.findByCartIdAndProductId(item.getCartId(), item.getProductId());
        if(existingItem == null) return addItem(item);
        item.setCartItemId(existingItem.getCartItemId());
        if(this.checkIfNoQty(item.getCartId(), item.getProductId()) || item.getCartQty() < 1) {
            this.removeItem(item.getCartItemId());
            item.setCartItemId(-1);
        } else {
            CartItemEntity itemEntity = new CartItemEntity(item.getCartItemId(), item.getCartId(), item.getProductId(), item.getCartQty());
//            CartItem returningItem = cartItemRepository.
            CartItemEntity returningItem = cartItemRepository.save(itemEntity);
        }

        return item;
    }

    @Override
    public CartItemPojo getCartItem(int item) throws ApplicationException {
        return null;
    }

    @Override
    public List<CartItemPojo> getAllItemsOfCart(int cartId) throws ApplicationException {
//        List<CartItemPojo> returningItems = new ArrayList<CartItemPojo>();
//        List<CartItem> allItems = cartItemRepository.findAllByCartId(cartId);
//        for()
        return null;
    }

    @Override
    public boolean removeItem(int itemId) throws ApplicationException {
        cartItemRepository.deleteById(itemId);
        return true;
    }

    @Override
    public boolean checkIfExistsInCart(int cartId, int productId) throws ApplicationException {

        return cartItemRepository.existsByCartIdAndProductId(cartId, productId);
    }

    @Override
    public boolean checkIfNoQty(int cartId, int productId) throws ApplicationException {
        return cartItemRepository.existsByCartQtyIsLessThanAndCartIdAndProductId(1, cartId, productId);
    }
}
