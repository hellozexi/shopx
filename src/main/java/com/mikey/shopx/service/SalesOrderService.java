package com.mikey.shopx.service;

import com.mikey.shopx.model.Customer;
import com.mikey.shopx.model.SalesOrder;
import com.mikey.shopx.repository.SalesOrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderService {
    private final static Logger logger = LoggerFactory.getLogger(SalesOrderService.class);

    @Autowired
    SalesOrderRepo salesOrderRepo;

    public void addSalesOrder(SalesOrder salesOrder) {
        try {
            salesOrderRepo.save(salesOrder);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public List<SalesOrder> getSalesOrderByProducer(Customer producer) {
        try {
            return salesOrderRepo.getAllByProducer(producer);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public List<SalesOrder> getSalesOrderByCustomer(Customer customer) {
        try {
            return salesOrderRepo.getAllByCustomer(customer);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }

    }
}
