package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

	Bid findByTenderAndVendor(Integer tenderId, Integer vendorId);

	List<Bid> findByVendor(Integer vendorId);

	List<Bid> findByTender(Integer tenderId);

}
