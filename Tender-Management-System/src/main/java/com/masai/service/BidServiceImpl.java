package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NotFoundException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;
import com.masai.repository.BidRepository;
import com.masai.repository.VendorRepository;

@Service
public class BidServiceImpl implements BidService {

	@Autowired
	private BidRepository bRepo;

	@Autowired
	private VendorRepository vRepo;

	@Autowired
	private TenderRepository tRepo;
	
	@Override
	public List<Bid> getAllBidsByVendor(Integer vendorId) throws NotFoundException {
		Optional<Vendor> vendor = vRepo.findById(vendorId);
		if (vendor.isPresent()) {
			Vendor v = vendor.get();
			return v.getBidList();
		} else {
			throw new NotFoundException("Tender not found with id " + vendorId);
		}

	}

	@Override
	public Bid submitBid(Bid bid) throws Exception {
		if (bid.getBidAmount() <= 0) {
			throw new IllegalArgumentException("Bid Amount must be greater than 0");
		}
		if (bid.getBidStatus() != "PENDING") {
			throw new IllegalArgumentException("Bid Status must be PENDING");
		}
		List<Bid> existingBid = bRepo.findByTenderIdAndVendorId(bid.getTender().getTenderId(),bid.getVendor().getVendorId());
		if (existingBid != null) {
			throw new IllegalArgumentException("Vendor has already submitted a bid for this tender");
		}
		Tender tender = tRepo.findById(bid.getTender().getTenderId());
	    if (tender == null) {
	        throw new IllegalArgumentException("Tender is not open for bidding.");
	    }
	    bid.setBidStatus("Available");
	    Bid res = bRepo.save(bid);
	    return res;
	}

	@Override
	public List<Bid> getBidHistoryByVendorId(Integer vendorId) {
		return bRepo.findByVendorId(vendorId);
	}

	@Override
	public Bid getBidByBidId(Integer bidId) throws Exception {
		return bRepo.findById(bidId).orElseThrow(() -> new Exception("Record Not Found By this Id"));
	}

	@Override
	public List<Bid> getBidsByTenderId(Integer tenderId) {
		return bRepo.findByTenderId(tenderId);
	}

	@Override
	public Bid updateBidStatus(Integer bidId, String bidStatus) throws Exception {
		if (bidStatus == null || bidStatus.isEmpty()) {
			throw new IllegalArgumentException("Bid Status must be provided");
		}
		Bid existingBid = bRepo.findById(bidId).orElse(null);
		if (existingBid == null) {
			throw new Exception("Bid id not found");
		}
		existingBid.setBidStatus(bidStatus);
		Bid res = bRepo.save(existingBid);
		return res;
	}
}
