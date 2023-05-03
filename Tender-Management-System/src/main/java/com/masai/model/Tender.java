package com.masai.model;

import java.time.LocalDate;
import java.util.List;

import com.masai.enums.TenderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Tender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tenderId;

	private String title;

	private String description;

	private LocalDate creationDate;

	private Integer basePrice;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "default 'AVAILABLE'")
	private TenderStatus status;

	@OneToOne
	@JoinColumn(name = "vendorId")
	private Vendor assignedVendor;

	@OneToMany(mappedBy = "tender", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Bid> biddings;

	public Tender() {
		// TODO Auto-generated constructor stub
	}

	public Tender(Integer tenderId, String title, String description, LocalDate creationDate, Integer basePrice,
			TenderStatus status, Vendor assignedVendor, List<Bid> biddings) {
		super();
		this.tenderId = tenderId;
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.basePrice = basePrice;
		this.status = status;
		this.assignedVendor = assignedVendor;
		this.biddings = biddings;
	}

	public Integer getTenderId() {
		return tenderId;
	}

	public void setTenderId(Integer tenderId) {
		this.tenderId = tenderId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}

	public TenderStatus getStatus() {
		return status;
	}

	public void setStatus(TenderStatus status) {
		this.status = status;
	}

	public Vendor getAssignedVendor() {
		return assignedVendor;
	}

	public void setAssignedVendor(Vendor assignedVendor) {
		this.assignedVendor = assignedVendor;
	}

	public List<Bid> getBiddings() {
		return biddings;
	}

	public void setBiddings(List<Bid> biddings) {
		this.biddings = biddings;
	}

}