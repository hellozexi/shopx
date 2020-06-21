package com.mikey.shopx.service;

import com.mikey.shopx.model.*;
import com.mikey.shopx.repository.*;
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

    @Autowired
    BillingAddressRepo billingAddressRepo;

    @Autowired
    ShippingAddressRepo shippingAddressRepo;

    public String addCustomer(Customer customer) {
        try {
            User user = customer.getUser();

            Role role = new Role();
            role.setName("ROLE_USER");
            role.setEmail(user.getEmail());
            roleRepo.save(role);
            user.setRoles(Collections.singleton(role));
            user.setCustomer(customer);

            Cart cart = new Cart();
            cart.setCustomer(customer);

            customer.setCart(cart);
            customerRepo.save(customer);

            return "Customer successfully added";
        } catch (Exception e) {
            return e.getMessage();
        }

    }
    public Customer getCustomerByUsername(String userName) {
        if(!userRepo.existsByUserName(userName)) {
            return null;
        }
        User user = userRepo.findByUserName(userName);
        Customer customer = customerRepo.getCustomerByUser(user);
        return customer;
    }

//    public Customer getCustomerByEmail(String email) {
//        User user = userRepo.findByEmail(email);
//        Customer customer = customerRepo.getCustomerByUser(user);
//        return customer;
//    }

}
