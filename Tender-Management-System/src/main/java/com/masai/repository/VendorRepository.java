package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	// This Method For the find Vendor by his UserName
	public Optional<Vendor> findByUsername(String username);

//    //This Method Fetch All Tenders
//    @Query("SELECT t FROM Tender t")
//    List<Tender> findAllTenders();
}
