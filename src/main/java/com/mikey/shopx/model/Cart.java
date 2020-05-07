package com.mikey.shopx.model;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    private static final long serialVersionUID = -5698160369575774823L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne(mappedBy = "cart")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItem;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private int totalPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
