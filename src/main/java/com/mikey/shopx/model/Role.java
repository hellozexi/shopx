package com.mikey.shopx.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "roles")
public class Role implements Serializable {


    private static final long serialVersionUID = 190992383010323519L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private RoleName name;

    public void setId(int id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
