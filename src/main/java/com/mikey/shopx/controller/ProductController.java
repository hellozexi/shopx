package com.mikey.shopx.controller;

import com.mikey.shopx.payload.AddProductRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/product")
public class ProductController {
    @PostMapping("update")
    public void addOrUpdateProduct(@Valid @RequestBody AddProductRequest addProductRequest) {

    }
}
