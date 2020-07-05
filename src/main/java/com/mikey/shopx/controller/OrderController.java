package com.mikey.shopx.controller;


import com.mikey.shopx.model.*;
import com.mikey.shopx.service.CartItemService;
import com.mikey.shopx.service.SalesOrderService;
import com.mikey.shopx.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
                salesOrder.setUnit(cartItem.getQuantity());
                salesOrderService.addSalesOrder(salesOrder);
                cartItemService.deleteCartItem(cartItem);
            }
            return new ResponseEntity<>("create salesOrders successfully", HttpStatus.OK);
            //return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOrdersFromCustomer")
    public ResponseEntity<?> getOrdersFromCustomer() {
        try{
            User currentUser = userService.getCurrentUser();
            Customer currentCustomer = currentUser.getCustomer();
            List<SalesOrder> ordersFromCustomer = salesOrderService.getSalesOrderByCustomer(currentCustomer);
            List<JSONObject> res = new ArrayList<>();
            for(SalesOrder salesOrder: ordersFromCustomer) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", salesOrder.getId());
                jsonObject.put("product", salesOrder.getProduct().getName());
                jsonObject.put("unit", salesOrder.getUnit());
                jsonObject.put("price", salesOrder.getUnit() * salesOrder.getProduct().getPrice());
                res.add(jsonObject);
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
            //return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOrdersFromProducer")
    public ResponseEntity<?> getOrdersFromProducer() {
        try{
            User currentUser = userService.getCurrentUser();
            Customer currentCustomer = currentUser.getCustomer();
            List<SalesOrder> ordersFromProducer = salesOrderService.getSalesOrderByProducer(currentCustomer);
            List<JSONObject> res = new ArrayList<>();
            for(SalesOrder salesOrder: ordersFromProducer) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", salesOrder.getId());
                jsonObject.put("product", salesOrder.getProduct().getName());
                jsonObject.put("unit", salesOrder.getUnit());
                jsonObject.put("price", salesOrder.getUnit() * salesOrder.getProduct().getPrice());
                res.add(jsonObject);
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
            //return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
