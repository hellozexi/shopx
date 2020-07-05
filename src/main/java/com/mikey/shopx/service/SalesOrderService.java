package com.mikey.shopx.service;

import com.mikey.shopx.model.SalesOrder;
import com.mikey.shopx.repository.SalesOrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
