package com.mikey.shopx.service;

import com.mikey.shopx.model.Cart;
import com.mikey.shopx.model.Customer;
import com.mikey.shopx.model.Role;
import com.mikey.shopx.model.RoleName;
import com.mikey.shopx.repository.CustomerRepo;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

//    public String addCustomer(Customer customer) {
//        Role role = new Role();
//        role.setName("ROLE_USER");
//
//        Cart cart = new Cart();
//        cart.setCustomer(customer);
//        customer.setCart(cart);
//    }

}
