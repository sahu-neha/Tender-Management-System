package com.masai.service;

import java.util.List;

import com.masai.exception.NotFoundException;
import com.masai.model.Bid;

public interface BidService {
	public Bid saveBidRecord(Bid bid)throws Exception;
	
	public List<Bid> getAllBidsByVendor(Integer vendorId) throws NotFoundException;
}
