package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.enums.BidStatus;
import com.masai.exception.NotFoundException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;
import com.masai.repository.BidRepository;
import com.masai.repository.TenderRepository;
import com.masai.repository.VendorRepository;

@Service
public class BidServiceImpl implements BidService {

	@Autowired
	private BidRepository bidRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private TenderRepository tenderRepository;

	@Override
	public List<Bid> getBidHistoryByVendorId(Integer vendorId) throws NotFoundException {

		Optional<Vendor> vendor = vendorRepository.findById(vendorId);

		if (vendor.isPresent()) {
			Vendor v = vendor.get();
			List<Bid> bidList = v.getBidList();
			if (bidList.size() == 0) {
				throw new NotFoundException("Bid not found");
			} else {
				return bidList;
			}
		} else {
			throw new NotFoundException("Tender not found with id " + vendorId);
		}

	}

//	@Override
//	public Bid submitBid(Bid bid) throws Exception {
//		if (bid.getBidAmount() <= 0) {
//			throw new IllegalArgumentException("Bid Amount must be greater than 0");
//		}
//		if (bid.getBidStatus() != "PENDING") {
//			throw new IllegalArgumentException("Bid Status must be PENDING");
//		}
//		List<Bid> existingBid = bidRepository.findByTenderIdAndVendorId(bid.getTender().getTenderId(),bid.getVendor().getVendorId());
//		if (existingBid != null) {
//			throw new IllegalArgumentException("Vendor has already submitted a bid for this tender");
//		}
//		Tender tender = tenderRepository.findById(bid.getTender().getTenderId());
//	    if (tender == null) {
//	        throw new IllegalArgumentException("Tender is not open for bidding.");
//	    }
//	    bid.setBidStatus("Available");
//	    Bid res = bidRepository.save(bid);
//	    return res;
//	}

	@Override
	public Bid getBidByBidId(Integer bidId) throws Exception {
		return bidRepository.findById(bidId).orElseThrow(() -> new Exception("Record Not Found By this Id"));
	}

	@Override
	public List<Bid> getBidsByTenderId(Integer tenderId) throws NotFoundException {
		Optional<Tender> tender = tenderRepository.findById(tenderId);

		if (tender.isPresent()) {
			Tender t = tender.get();
			List<Bid> bidList = t.getBidList();
			if (bidList.size() == 0) {
				throw new NotFoundException("Bid not found");
			} else {
				return bidList;
			}
		} else {
			throw new NotFoundException("Tender not found with id " + tenderId);
		}
		

	}

	@Override
	public Bid updateBidStatus(Integer bidId, String bidStatus) throws Exception {

		if (bidStatus == null || bidStatus.isEmpty()) {
			throw new IllegalArgumentException("Bid Status must be provided");
		}

		Bid existingBid = bidRepository.findById(bidId).orElseThrow(() -> new Exception("Record Not Found By this Id"));

		existingBid.setBidStatus(bidStatus.toLowerCase().equals("approved") ? BidStatus.APPROVED
				: bidStatus.toLowerCase().equals("rejected") ? BidStatus.REJECTED : BidStatus.PENDING);
		Bid res = bidRepository.save(existingBid);

		return res;
	}
}
