package com.mikey.shopx.repository;

import com.mikey.shopx.model.Customer;
import com.mikey.shopx.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer getCustomerByUser(User user);
}
