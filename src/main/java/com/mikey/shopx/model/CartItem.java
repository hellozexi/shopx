package com.mikey.shopx.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "cartItem")
public class CartItem implements Serializable {

    private static final long serialVersionUID = -7819078528555738933L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private int quantity;
    private int price;

    @ManyToOne
    @JsonIgnore
    Cart cart;

    @OneToOne
    private Product product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
