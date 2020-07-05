package com.mikey.shopx.controller;


import com.mikey.shopx.model.*;
import com.mikey.shopx.service.CartItemService;
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

import java.util.List;

@Controller
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    SalesOrderService salesOrderService;

    @Autowired
    UserService userService;

    @Autowired
    CartItemService cartItemService;

    @PostMapping("/submitOrder")
    public ResponseEntity<?> submitOrder() {
        try{
            User currentUser = userService.getCurrentUser();
            Customer currentCustomer = currentUser.getCustomer();
            Cart currentCart = currentCustomer.getCart();
            List<CartItem> cartItems = currentCart.getCartItems();
            for(CartItem cartItem: cartItems) {
                SalesOrder salesOrder = new SalesOrder();
                salesOrder.setCart(currentCart);
                salesOrder.setProducer(cartItem.getProduct().getCustomer());
                salesOrder.setCustomer(currentCustomer);
                salesOrder.setProduct(cartItem.getProduct());
                salesOrderService.addSalesOrder(salesOrder);
                cartItemService.deleteCartItem(cartItem);
            }
            return new ResponseEntity<>("create salesOrders successfully", HttpStatus.OK);
            //return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
