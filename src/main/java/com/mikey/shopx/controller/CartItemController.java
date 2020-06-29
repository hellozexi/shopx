package com.mikey.shopx.controller;

import com.mikey.shopx.model.*;
import com.mikey.shopx.repository.ProductRepo;
import com.mikey.shopx.repository.UserRepo;
import com.mikey.shopx.service.CartItemService;
import com.mikey.shopx.service.CartService;
import com.mikey.shopx.service.CustomerService;
import com.mikey.shopx.service.ProductService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {

    @Autowired
    ProductService productService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    CustomerService customerService;

    @Autowired
    CartService cartService;
    @Autowired
    CartItemService cartItemService;

    @GetMapping("getitems")
    public ResponseEntity<?> getCartItems() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = auth.getName();

            Customer customer = customerService.getCustomerByUsername(currentUserName);

            Cart cart = customer.getCart();
            List<CartItem> cartItems = cart.getCartItems();
            List<JSONObject> objects = new ArrayList<>();
            for(CartItem cartItem: cartItems) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", cartItem.getProduct().getName());
                jsonObject.put("quantity", cartItem.getQuantity());
                jsonObject.put("id", cartItem.getId());
                objects.add(jsonObject);
            }
            return new ResponseEntity<>(objects, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/add/{productId}")
    public ResponseEntity<?> addCartItem(@PathVariable Long productId) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = auth.getName();

            Customer customer = customerService.getCustomerByUsername(currentUserName);

            Cart cart = customer.getCart();
            List<CartItem> cartItems = cart.getCartItems();
            Product product = productService.getProductById(productId);
            /**
             * if there exists a cartItem in cartItems from current user, we should update it's quantity and total price
             * */
            for(CartItem cartItem: cartItems) {
                if(cartItem.getProduct().getId() == productId) {
                    if(cartItem.getQuantity() < product.getUnit()) {
                        cartItem.setQuantity(cartItem.getQuantity() + 1);
                        cartItem.setPrice(cartItem.getQuantity() * cartItem.getProduct().getPrice());
                        cartItemService.addCartItem(cartItem);
                        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
                        cartService.updateCart(cart);
                        return new ResponseEntity<>("cart item " + productId + "updated successfully", HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>("quantity exceed the maximum volume", HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }
            }
            CartItem cartItem = new CartItem();
            cartItem.setPrice(product.getPrice());
            cartItem.setQuantity(1);
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItemService.addCartItem(cartItem);
            cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
            cartService.updateCart(cart);
            return new ResponseEntity<>("add cart item successfully to " + currentUserName + " 's cart", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
