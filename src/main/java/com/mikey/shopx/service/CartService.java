package com.mikey.shopx.service;

import com.mikey.shopx.model.Cart;
import com.mikey.shopx.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CartService {
    @Autowired
    public CartRepo cartRepo;

    public Cart getCartById(Long id) {
        return cartRepo.getCartById(id);
    }
}
