package com.mikey.shopx.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "salesOrder")
public class SalesOrder implements Serializable {
    private static final long serialVersionUID = -7457080375999897352L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Cart cart;

    @OneToOne
    Customer customer;

    @OneToOne
    Customer producer;

    @OneToOne
    Product product;

    public Customer getProducer() {
        return producer;
    }

    public void setProducer(Customer producer) {
        this.producer = producer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
