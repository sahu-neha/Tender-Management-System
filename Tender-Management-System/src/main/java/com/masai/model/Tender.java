package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.masai.enums.TenderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tenderId;

	@NotBlank(message = "Title is required")
	private String title;

	@NotBlank(message = "Description is required")
	private String description;
	
	@NotBlank(message = "Image is required")
	private String image;

	@NotNull(message = "Creation date is required")
	private LocalDate creationDate;

	@Positive(message = "Duration must be a positive number")
	private int durationInDays;

	@Positive(message = "Tender price must be a positive number")
	private int tenderPrice;

	@Enumerated(EnumType.STRING)
	private TenderStatus status = TenderStatus.AVAILABLE;

	@OneToOne
	@JoinColumn(name = "vendorId")
	private Vendor assignedVendor;

	@OneToMany
	private List<Vendor> vendorList = new ArrayList<>();
    
	@JsonIgnore
	@OneToMany(mappedBy = "tender")
	private List<Bid> bidList = new ArrayList<>();

}