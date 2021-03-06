package com.mikey.shopx.controller;

import com.mikey.shopx.model.Customer;
import com.mikey.shopx.model.Product;
import com.mikey.shopx.model.User;
import com.mikey.shopx.payload.AddProductRequest;
import com.mikey.shopx.repository.ProductRepo;
import com.mikey.shopx.repository.UserRepo;
import com.mikey.shopx.service.CustomerService;
import com.mikey.shopx.service.ProductService;
import com.mikey.shopx.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

    @PostMapping("add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody AddProductRequest addProductRequest) {
        try {
            User currentUser = userService.getCurrentUser();
            Customer currentCustomer = currentUser.getCustomer();
            Product product = new Product();

            String name = addProductRequest.getName();
            String category = addProductRequest.getCategory();
            String description = addProductRequest.getDescription();
            int price = addProductRequest.getPrice();
            int unit = addProductRequest.getUnit();

            product.setName(name);
            product.setCategory(category);
            product.setPrice(price);
            product.setUnit(unit);
            product.setDescription(description);
            product.setCustomer(currentCustomer);
            productService.addOrUpdateProduct(product);
            return new ResponseEntity<>("product saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getAll")
    @ResponseBody
    public ResponseEntity<?> getProducts() {
        List<JSONObject> res = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        for(Product product: products) {
            JSONObject jsonObject = product.toJSONObject();
            jsonObject.put("provider", product.getCustomer().getUser().getUserName());
            res.add(jsonObject);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("getAllFromUser/{userName}")
    @ResponseBody
    public ResponseEntity<?> getAllProducts(@PathVariable String userName) {
        try {
            Customer customer = customerService.getCustomerByUsername(userName);
            List<JSONObject> res = new ArrayList<>();
            List<Product> products = productService.getAllProductByCustomer(customer);
            for(Product product: products) {
                JSONObject jsonObject = product.toJSONObject();
                res.add(jsonObject);
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("something wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getAllFromCurrentUser")
    @ResponseBody
    public ResponseEntity<?> getAllProducts() {
        try {
            User currentUser = userService.getCurrentUser();

            Customer customer = currentUser.getCustomer();

            List<JSONObject> res = new ArrayList<>();
            List<Product> products = productService.getAllProductByCustomer(customer);
            for(Product product: products) {
                JSONObject jsonObject = product.toJSONObject();
                res.add(jsonObject);
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("something wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("delete/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        try {
            productService.deleteProduct(productId);
            return new ResponseEntity<>("delete: " + productId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("can't delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
