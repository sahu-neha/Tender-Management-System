package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Tender;

@Repository
public interface TenderRepository extends JpaRepository<Tender, Integer> {

	
	
}
