package com.mikey.shopx.service;

import com.mikey.shopx.Security.JwtTokenProvider;
import com.mikey.shopx.model.Customer;
import com.mikey.shopx.model.Product;
import com.mikey.shopx.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public void addOrUpdateProduct(Product product) {
        try {
            productRepo.save(product);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    public void deleteProduct(Long productId) {
        try {
            Product product = productRepo.getProductById(productId);
            productRepo.delete(product);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    public List<Product> getAllProducts() {
        try {
            List<Product> products = productRepo.findAll();
            return products;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public List<Product> getAllProductByCategory(String category) {
        try {
            List<Product> products = productRepo.findAllByCategory(category);
            return products;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public List<Product> getAllProductByCustomer(Customer customer) {
        try {
            List<Product> products = productRepo.findAllByCustomer(customer);
            return products;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

}
