package com.mikey.shopx.repository;

import com.mikey.shopx.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {
    CartItem getCartItemById(Long id);
}
