package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Dispute;
import com.masai.model.Tender;

@Repository
public interface DisputeRepository extends JpaRepository<Dispute, Integer> {

	
	
}
