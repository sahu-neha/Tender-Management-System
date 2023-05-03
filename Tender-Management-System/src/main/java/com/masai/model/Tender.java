package com.masai.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String title;
    
    private String description;
    
    private LocalDate creationDate;
    
    @Enumerated(EnumType.STRING)
    private TenderStatus status;
    
    @ManyToOne
    @JoinColumn(name = "vendorId")
    private Vendor assignedVendor;
    
    @ManyToOne
    @JoinColumn(name = "adminId")
    private Administrator createdBy;
    

}