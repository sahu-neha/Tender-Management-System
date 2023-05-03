package com.masai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

	@OneToOne
	@JoinColumn(name = "vendorId")
	private Vendor vendor;

	@Positive(message = "Bid Amount price must be a positive number")
	private Integer bidAmount;

	@Positive(message = "Days must be a positive number")
	private Integer durationInDays;

	@Column(columnDefinition = "VARCHAR(10) DEFAULT 'PENDING'")
	private String bidStatus;

}