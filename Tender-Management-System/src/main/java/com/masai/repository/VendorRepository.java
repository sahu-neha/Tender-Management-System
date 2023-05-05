package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Tender;
import com.masai.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	// This Method For the find Vendor by his UserName
	public Optional<Vendor> findByUsername(String username);


}
