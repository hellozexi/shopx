package com.mikey.shopx.repository;

import com.mikey.shopx.model.Customer;
import com.mikey.shopx.model.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesOrderRepo extends JpaRepository<SalesOrder, Long> {
    List<SalesOrder> getAllByProducer(Customer producer);
    List<SalesOrder> getAllByCustomer(Customer customer);
}
