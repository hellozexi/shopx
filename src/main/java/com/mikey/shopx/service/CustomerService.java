package com.mikey.shopx.service;

import com.mikey.shopx.model.*;
import com.mikey.shopx.repository.CartRepo;
import com.mikey.shopx.repository.CustomerRepo;
import com.mikey.shopx.repository.RoleRepo;
import com.mikey.shopx.repository.UserRepo;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    UserRepo userRepo;
    public String addCustomer(Customer customer) {
        User user = customer.getUser();

        Role role = new Role();
        role.setName("ROLE_USER");
        role.setEmail(user.getEmail());

        user.setRoles(Collections.singleton(role));

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        customerRepo.save(customer);
        cartRepo.save(cart);
        roleRepo.save(role);
        userRepo.save(user);
        return "Customer successfully added";
    }

    public Customer getCustomerByUsername(String userName) {
        if(!userRepo.existsByUserName(userName)) {
            return null;
        }
        User user = userRepo.findByUserName(userName);
        Customer customer = customerRepo.getCustomerByUser(user);
        return customer;
    }

    public Customer getCustomerByEmail(String email) {
        User user = userRepo.findByEmail(email);
        Customer customer = customerRepo.getCustomerByUser(user);
        return customer;
    }

}
