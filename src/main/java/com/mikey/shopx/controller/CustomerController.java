package com.mikey.shopx.controller;

import com.mikey.shopx.Security.JwtAuthenticationEntryPoint;
import com.mikey.shopx.model.*;
import com.mikey.shopx.payload.AddCustomerRequest;
import com.mikey.shopx.Security.CurrentUser;
import com.mikey.shopx.Security.UserPrincipal;
import com.mikey.shopx.repository.CustomerRepo;
import com.mikey.shopx.repository.UserRepo;
import com.mikey.shopx.service.CustomerService;
import com.mikey.shopx.service.ProductService;
import com.mikey.shopx.service.UserService;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;
    @Autowired
    UserRepo userRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CustomerService customerService;

    @GetMapping("getallproducts")
    @ResponseBody
    public ResponseEntity<?> getAllProducts() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = auth.getName();
            //String currentUserName = userPrincipal.getUsername();
            User currentUser = userRepo.findByUserName(currentUserName);

            Customer customer = customerService.getCustomerByUsername(currentUserName);

            List<JSONObject> res = new ArrayList<>();
            List<Product> products = productService.getAllProductByCustomer(customer);
            for(Product product: products) {
                JSONObject jsonObject = product.toJSONObject();
                res.add(jsonObject);
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("something wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("update")
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody AddCustomerRequest addCustomerRequest) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = auth.getName();
            //String currentUserName = userPrincipal.getUsername();
            User currentUser = userRepo.findByUserName(currentUserName);

            Customer customer = customerService.getCustomerByUsername(currentUserName);

            String billingAdr = addCustomerRequest.getBillingAddress();
            String billingCity = addCustomerRequest.getBillingCity();
            String billingState = addCustomerRequest.getBillingState();
            String billingZipCode = addCustomerRequest.getBillingZipCode();
            String billingCountry = addCustomerRequest.getBillingCountry();



            String shippingAdr = addCustomerRequest.getShippingAddress();
            String shippingCity = addCustomerRequest.getShippingCity();
            String shippingState = addCustomerRequest.getShippingState();
            String shippingZipCode = addCustomerRequest.getShippingZipCode();
            String shippingCountry = addCustomerRequest.getShippingCountry();





            if(customer == null) {
                customer = new Customer();
                customer.setUser(currentUser);
                BillingAddress billingAddress = new BillingAddress(billingAdr, billingCity, billingState, billingZipCode, billingCountry, customer);
                ShippingAddress shippingAddress = new ShippingAddress(shippingAdr, shippingCity, shippingState, shippingZipCode, shippingCountry, customer);
                customer.setBillingAddress(billingAddress);
                customer.setShippingAddress(shippingAddress);
                customer.setFirstName(addCustomerRequest.getFirstName());
                customer.setLastName(addCustomerRequest.getLastName());
                customer.setCustomerPhone(addCustomerRequest.getCustomerPhone());
                String msg = customerService.addCustomer(customer);
                logger.info(msg);

            } else {
                BillingAddress billingAddress = customer.getBillingAddress();
                billingAddress.setAddress(billingAdr);
                billingAddress.setCity(billingCity);
                billingAddress.setState(billingState);
                billingAddress.setZipCode(billingZipCode);
                billingAddress.setCountry(billingCountry);
                customer.setBillingAddress(billingAddress);

                ShippingAddress shippingAddress = customer.getShippingAddress();
                shippingAddress.setAddress(shippingAdr);
                shippingAddress.setCity(shippingCity);
                shippingAddress.setState(shippingState);
                shippingAddress.setZipCode(shippingZipCode);
                shippingAddress.setCountry(shippingCountry);
                customer.setShippingAddress(shippingAddress);
                customer.setFirstName(addCustomerRequest.getFirstName());
                customer.setLastName(addCustomerRequest.getLastName());
                customer.setCustomerPhone(addCustomerRequest.getCustomerPhone());
                customerRepo.save(customer);
                logger.info("Updated customer successfully");
            }

            return new ResponseEntity<>("save successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
