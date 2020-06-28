package com.mikey.shopx.service;

import com.mikey.shopx.model.Cart;
import com.mikey.shopx.repository.CartRepo;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CartService {
    @Autowired
    public CartRepo cartRepo;

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);


    public Cart getCartById(Long id) {
        return cartRepo.getCartById(id);
    }

    public void updateCart(Cart cart) {
        try {
            cartRepo.save(cart);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
