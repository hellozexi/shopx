package com.mikey.shopx.repository;

import com.mikey.shopx.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Product getProductById(Long id);
    //List<Product> findAll();
    List<Product> findAllByCategory(String category);
}
