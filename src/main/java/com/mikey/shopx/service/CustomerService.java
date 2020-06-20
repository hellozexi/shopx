package com.mikey.shopx.service;

import com.mikey.shopx.model.*;
import com.mikey.shopx.repository.CartRepo;
import com.mikey.shopx.repository.CustomerRepo;
import com.mikey.shopx.repository.RoleRepo;
import com.mikey.shopx.repository.UserRepo;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Role role = new Role();
        role.setName("ROLE_USER");
        role.setEmail(customer.getUser().getEmail());

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        customerRepo.save(customer);
        cartRepo.save(cart);
        roleRepo.save(role);
        return "Customer successfully added";
    }

    public Customer getCustomerByUsername(String userName) {
        User user = userRepo.findByUserName(userName);
        Customer customer = customerRepo.getCustomerByUser(user);
        return customer;
    }

    public Customer getCustomerByEmail(String email) {
        User user = userRepo.findByEmail(email);
        Customer customer = customerRepo.getCustomerByUser(user);
        return customer;
    }

    public Customer getCustomerByUserNameOrEmail(String userName, String email) {
        User user = userRepo.findByUserNameOrEmail(userName, email);
        Customer customer = customerRepo.getCustomerByUser(user);
        return customer;
    }
}
