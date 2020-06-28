package com.mikey.shopx.repository;

import com.mikey.shopx.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    Cart getCartById(Long id);
}
