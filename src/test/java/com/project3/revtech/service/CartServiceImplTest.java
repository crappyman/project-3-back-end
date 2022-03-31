package com.project3.revtech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.project3.revtech.dao.CartRepository;
import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.TransactionEntity;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.CartPojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CartServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CartServiceImplTest {
    @MockBean
    private CartRepository cartRepository;

    @Autowired
    private CartServiceImpl cartServiceImpl;

    @Test
    void testAddCart() throws ApplicationException {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setCartId(123);
        transaction.setTransactionDate(mock(Timestamp.class));
        transaction.setTransactionId(123);

        UserEntity user = new UserEntity();
        user.setAddress("42 Main St");
        user.setContact("Contact");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(1);
        user.setUsername("janedoe");

        CartEntity cart = new CartEntity();
        cart.setCartId(123);
        cart.setCartItems(new ArrayList<>());
        cart.setCartPaid(true);
        cart.setCartRemoved(true);
        cart.setCartTotal(1);
        cart.setTransactionEntity(transaction);
        cart.setUserEntity(user);
        cart.setUserId(123);
        when(this.cartRepository.saveAndFlush((CartEntity) any())).thenReturn(cart);
        CartPojo cartPojo = new CartPojo(123, 123, 1, true, true);

        CartPojo actualAddCartResult = this.cartServiceImpl.addCart(cartPojo);
        assertSame(cartPojo, actualAddCartResult);
        assertEquals(123, actualAddCartResult.getCartId());
        verify(this.cartRepository).saveAndFlush((CartEntity) any());
    }

    @Test
    void testUpdateCart() throws ApplicationException {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setCartId(123);
        transaction.setTransactionDate(mock(Timestamp.class));
        transaction.setTransactionId(123);

        UserEntity user = new UserEntity();
        user.setAddress("42 Main St");
        user.setContact("Contact");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(1);
        user.setUsername("janedoe");

        CartEntity cart = new CartEntity();
        cart.setCartId(123);
        cart.setCartItems(new ArrayList<>());
        cart.setCartPaid(true);
        cart.setCartRemoved(true);
        cart.setCartTotal(1);
        cart.setTransactionEntity(transaction);
        cart.setUserEntity(user);
        cart.setUserId(123);
        when(this.cartRepository.saveAndFlush((CartEntity) any())).thenReturn(cart);
        CartPojo cartPojo = new CartPojo(123, 123, 1, true, true);

        CartPojo actualUpdateCartResult = this.cartServiceImpl.updateCart(cartPojo);
        assertSame(cartPojo, actualUpdateCartResult);
        assertEquals(123, actualUpdateCartResult.getCartId());
        verify(this.cartRepository).saveAndFlush((CartEntity) any());
    }

    @Test
    void testGetCart() throws ApplicationException {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setCartId(123);
        transaction.setTransactionDate(mock(Timestamp.class));
        transaction.setTransactionId(123);

        UserEntity user = new UserEntity();
        user.setAddress("42 Main St");
        user.setContact("Contact");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(1);
        user.setUsername("janedoe");

        CartEntity cart = new CartEntity();
        cart.setCartId(123);
        cart.setCartItems(new ArrayList<>());
        cart.setCartPaid(true);
        cart.setCartRemoved(true);
        cart.setCartTotal(1);
        cart.setTransactionEntity(transaction);
        cart.setUserEntity(user);
        cart.setUserId(123);
        when(this.cartRepository.findByCartId(anyInt())).thenReturn(cart);
        CartPojo actualCart = this.cartServiceImpl.getCart(123);
        assertEquals(123, actualCart.getCartId());
        assertTrue(actualCart.isCartRemoved());
        assertTrue(actualCart.isCartPaid());
        assertEquals(123, actualCart.getUserId());
        assertEquals(1, actualCart.getCartTotal());
        verify(this.cartRepository).findByCartId(anyInt());
    }

    @Test
    void testGetCartByUserId() throws ApplicationException {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setCartId(123);
        transaction.setTransactionDate(mock(Timestamp.class));
        transaction.setTransactionId(123);

        UserEntity user = new UserEntity();
        user.setAddress("42 Main St");
        user.setContact("Contact");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(1);
        user.setUsername("janedoe");

        CartEntity cart = new CartEntity();
        cart.setCartId(123);
        cart.setCartItems(new ArrayList<>());
        cart.setCartPaid(true);
        cart.setCartRemoved(true);
        cart.setCartTotal(1);
        cart.setTransactionEntity(transaction);
        cart.setUserEntity(user);
        cart.setUserId(123);
        when(this.cartRepository.findByUserId(anyInt())).thenReturn(cart);
        CartPojo actualCartByUserId = this.cartServiceImpl.getCartByUserId(123);
        assertEquals(123, actualCartByUserId.getCartId());
        assertTrue(actualCartByUserId.isCartRemoved());
        assertTrue(actualCartByUserId.isCartPaid());
        assertEquals(123, actualCartByUserId.getUserId());
        assertEquals(1, actualCartByUserId.getCartTotal());
        verify(this.cartRepository).findByUserId(anyInt());
    }

    @Test
    void testRemoveCart() throws ApplicationException {
        doNothing().when(this.cartRepository).deleteById((Integer) any());
        assertTrue(this.cartServiceImpl.removeCart(new CartPojo(123, 123, 1, true, true)));
        verify(this.cartRepository).deleteById((Integer) any());
    }
}

