package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tenderId;

	private String title;

	private String description;

	private LocalDate creationDate;

	private Integer durationInDays;

	private Integer tenderPrice;

	@Column(columnDefinition = "default 'Available'")
	private String status;

	@OneToOne
	@JoinColumn(name = "vendorId")
	private Vendor assignedVendor;

	@OneToMany
	private List<Vendor> vendorList = new ArrayList<>();

}