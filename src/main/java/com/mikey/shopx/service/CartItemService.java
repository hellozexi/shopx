package com.mikey.shopx.service;

import com.mikey.shopx.model.Cart;
import com.mikey.shopx.model.CartItem;
import com.mikey.shopx.repository.CartItemRepo;
import com.mikey.shopx.repository.CartRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    CartRepo cartRepo;

    private static final Logger logger = LoggerFactory.getLogger(CartItemService.class);

    @Autowired
    CartItemRepo cartItemRepo;
    public void addCartItem(CartItem cartItem) {
        try {
            cartItemRepo.save(cartItem);
        } catch (Exception e) {
            logger.error(String.valueOf(e));
        }
    }

    public void deleteCartItem(CartItem cartItem) {
        try {
            Cart cart = cartItem.getCart();
            List<CartItem>  cartItems = cart.getCartItems();
            cartItems.remove(cartItem);
            cartItemRepo.delete(cartItem);
        } catch (Exception e) {
            logger.error(String.valueOf(e));
        }
    }


}
