package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer>{
	
	List<Bid> findByTenderIdAndVendorId(Integer tenderId,Integer vendorId);
	
	List<Bid> findByVendorId(Integer vendorId);
	
	List<Bid> findByTenderId(Integer tenderId);

}
