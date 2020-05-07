package com.mikey.shopx.repository;

import com.mikey.shopx.model.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAddressRepo extends JpaRepository<BillingAddress, Long> {
}
