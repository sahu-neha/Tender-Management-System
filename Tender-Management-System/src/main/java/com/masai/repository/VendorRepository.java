package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	/**
	* This method retrieves the vendor by vendor's username.
	*
	* @param username The username is use for retrieved vendor information
	* @return A ResponseEntity of vendor and HTTP status code OK
	* @Author HoshiyarJyani
	*/
	public Optional<Vendor> findByUsername(String username);

  
}
