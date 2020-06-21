package com.mikey.shopx.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "roles")
public class Role implements Serializable {


    private static final long serialVersionUID = 190992383010323519L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
