package com.mikey.shopx.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {


    private static final long serialVersionUID = 190992383010323519L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String aothorities;

    private String emailId;

    public String getEmailId() {
        return emailId;
    }

    public int getId() {
        return id;
    }

    public String getAothorities() {
        return aothorities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAothorities(String aothorities) {
        this.aothorities = aothorities;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
