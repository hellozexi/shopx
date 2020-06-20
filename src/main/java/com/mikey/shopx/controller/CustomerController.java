package com.mikey.shopx.controller;

import com.mikey.shopx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {


    @Autowired
    UserService userService;

//    @Autowired
//    CustomerService customerService;
//    @PostMapping("update")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody AddCustomerRequest addCustomerRequest) {
//        User currentUser = userService.getCurrentUser();
//        String currentUserName = userService.getCurrentUserName();
////        if(currentUser == null || currentUserName == null) {
////            return new ResponseEntity<>("user not log in", HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////        Customer customer = customerService.getCustomerByUsername(currentUserName);
////        if(customer == null) {
////            customer = new Customer();
////            customer.setUser(currentUser);
////            customer.setBillingAddress(addCustomerRequest.getBillingAddress());
////        }
//
//    }

    @GetMapping("currentuser")
    @ResponseBody
    public String registerUser(Authentication authentication) {
        return authentication.getName();
//        if(currentUser == null || currentUserName == null) {
//            return new ResponseEntity<>("user not log in", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        Customer customer = customerService.getCustomerByUsername(currentUserName);
//        if(customer == null) {
//            customer = new Customer();
//            customer.setUser(currentUser);
//            customer.setBillingAddress(addCustomerRequest.getBillingAddress());
//        }

    }
}
