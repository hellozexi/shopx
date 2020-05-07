package com.mikey.shopx.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "salesOrder")
public class SalesOrder implements Serializable {
    private static final long serialVersionUID = -7457080375999897352L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne
    private Cart cart;

    @OneToMany
    Customer customer;

    @OneToOne
    ShippingAddress shippingAddress;

    @OneToOne
    BillingAddress billingAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }
}
