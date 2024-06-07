package com.ml.housecost.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ResidentialComplex extends ListObject{
    @Id
    private Integer id;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
