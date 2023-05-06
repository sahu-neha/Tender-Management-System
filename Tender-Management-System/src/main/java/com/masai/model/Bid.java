package com.masai.model;

import com.masai.enums.BidStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "tenderId")
	private Tender tender;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorId")
	private Vendor vendor;

	@Positive(message = "Bid Amount price must be a positive number")
	private Integer bidAmount;

	@Positive(message = "Days must be a positive number")
	private Integer durationInDays;

	@Enumerated(EnumType.STRING)
	private BidStatus bidStatus = BidStatus.PENDING;

}