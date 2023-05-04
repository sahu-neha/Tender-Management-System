package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NotFoundException;
import com.masai.model.Bid;
import com.masai.model.Vendor;
import com.masai.repository.BidRepository;
import com.masai.repository.VendorRepository;

@Service
public class BidServiceImpl implements BidService {

	@Autowired
	private BidRepository bRepo;
	
	@Autowired 
	private VendorRepository vRepo;
	
	
	@Override
	public List<Bid> getAllBidsByVendor(Integer vendorId) throws NotFoundException {
		Optional<Vendor> vendor = vRepo.findById(vendorId);
		if(vendor.isPresent()) {
			Vendor v = vendor.get();
			return v.getBidList();
		}else {
			throw new NotFoundException("Tender not found with id " + vendorId);
		}
		
	}


	@Override
	public Bid saveBidRecord(Bid bid) throws Exception {
		Optional<Bid> check = bRepo.findById(bid.getId());
		if(check.isPresent()) {
			throw new Exception("Record already Present");
		}
		return bRepo.save(bid);
	}

}
