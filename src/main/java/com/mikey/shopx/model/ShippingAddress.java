package com.mikey.shopx.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shippingAddress")
public class ShippingAddress implements Serializable {

    private static final long serialVersionUID = -4232178425126437130L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public ShippingAddress() {
    }

    public ShippingAddress(String address, String city, String state, String zipCode, String country, Customer customer) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.customer = customer;
    }

    @OneToOne(mappedBy = "shippingAddress")
    //@JsonManagedReference
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
