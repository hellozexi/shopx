package com.mikey.shopx.repository;

import com.mikey.shopx.model.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepo extends JpaRepository<SalesOrder, Long> {
}
