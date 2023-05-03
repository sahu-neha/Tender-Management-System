package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
