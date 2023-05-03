package com.masai.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.enums.BidStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
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
	private Integer biddingId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tenderId")
	private Tender tender;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "vendorId")
	private Vendor vendor;

	private BigDecimal biddingAmount;

	private Integer estimatedTime;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "default 'PENDING'")
	private BidStatus status;

	public Bid() {
		// TODO Auto-generated constructor stub
	}

	public Bid(Tender tender, Vendor vendor, BigDecimal biddingAmount, Integer estimatedTime) {
		super();

		this.tender = tender;
		this.vendor = vendor;
		this.biddingAmount = biddingAmount;
		this.estimatedTime = estimatedTime;

	}

	public Integer getBiddingId() {
		return biddingId;
	}

	public void setBiddingId(Integer biddingId) {
		this.biddingId = biddingId;
	}

	public Tender getTender() {
		return tender;
	}

	public void setTender(Tender tender) {
		this.tender = tender;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public BigDecimal getBiddingAmount() {
		return biddingAmount;
	}

	public void setBiddingAmount(BigDecimal biddingAmount) {
		this.biddingAmount = biddingAmount;
	}

	public Integer getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(Integer estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public BidStatus getStatus() {
		return status;
	}

	public void setStatus(BidStatus status) {
		this.status = status;
	}

}