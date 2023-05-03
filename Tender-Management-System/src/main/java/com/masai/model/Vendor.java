package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vendorId;
	
	private String name;

	@Max(value = 5, message = "Rating can not be higher than 5")
	@Column(columnDefinition = "default '5'")
	private Integer rating;

	@Column(unique = true)
	@Size(min = 4, max = 20, message = "Username should be between 4 to 20 letters")
	private String username;

	@JsonIgnore
	private String password;

	@Column(columnDefinition = "default 'true'")
	private boolean isActive;

	@Column(columnDefinition = "default 'true'")
	private boolean isEligible;

	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Bid> biddings;
	public Vendor() {
		// TODO Auto-generated constructor stub
	}

	public Vendor(Integer vendorId, String name,
			@Max(value = 5, message = "Rating can not be higher than 5") Integer rating,
			@Size(min = 4, max = 20, message = "Username should be between 4 to 20 letters") String username,
			String password, boolean isActive, boolean isEligible, List<Bid> biddings) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.rating = rating;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.isEligible = isEligible;
		this.biddings = biddings;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isEligible() {
		return isEligible;
	}

	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}

	public List<Bid> getBiddings() {
		return biddings;
	}

	public void setBiddings(List<Bid> biddings) {
		this.biddings = biddings;
	}
	
}