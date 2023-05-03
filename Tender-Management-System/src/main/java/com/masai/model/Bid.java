package com.masai.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "tenderId")
    private Tender tender;
    
    @ManyToOne
    @JoinColumn(name = "vendorId")
    private Vendor vendor;
    
    private BigDecimal amount;
    
    @Enumerated(EnumType.STRING)
    private BidStatus status;
    
   
}