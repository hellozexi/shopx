package com.mikey.shopx.controller;

import com.mikey.shopx.model.Product;
import com.mikey.shopx.model.User;
import com.mikey.shopx.payload.AddProductRequest;
import com.mikey.shopx.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("add")
    public void addProduct(@Valid @RequestBody AddProductRequest addProductRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();
        //String currentUserName = userPrincipal.getUsername();
        User currentUser = userRepo.findByUserName(currentUserName);
        Product product = new Product();

    }
}
