package com.mikey.shopx.controller;


import com.mikey.shopx.model.User;
import com.mikey.shopx.service.SalesOrderService;
import com.mikey.shopx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    SalesOrderService salesOrderService;

    @Autowired
    UserService userService;
    @Autowired


    @PostMapping("/submitOrder")
    public ResponseEntity<?> submitOrder() {
        try{
            User currentUser = userService.getCurrentUser();
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
