package com.masai.model;

import jakarta.persistence.Entity;

@Entity
public class Vendor extends User {
    private String companyName;
    private boolean active;
    

}