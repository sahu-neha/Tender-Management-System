package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.NotFoundException;
import com.masai.model.Bid;
import com.masai.service.BidService;

@RestController
@CrossOrigin(origins = "*")
public class BidController {
	
	@Autowired
	private BidService bidService;
	
	
	@GetMapping("bids/vendor/{vendorId}")
	public ResponseEntity<List<Bid>> fetchAllBidsByVendor(@PathVariable Integer vendorId) throws NotFoundException{
		List<Bid> res = bidService.getBidHistoryByVendorId(vendorId);
		return new ResponseEntity<List<Bid>>(res,HttpStatus.FOUND);
	}
	
	@GetMapping("/bids/bid/{Id}")
	public ResponseEntity<Bid> fetchBidByBidId(@PathVariable Integer Id) throws Exception{
		Bid res = bidService.getBidByBidId(Id);
		return new ResponseEntity<Bid>(res,HttpStatus.FOUND);
	}
	
	@GetMapping("/bids/tender/{tenderId}")
	public ResponseEntity<List<Bid>> fetchBidsByTenderId(@PathVariable Integer tenderId) throws Exception{
		List<Bid> res = bidService.getBidsByTenderId(tenderId);
		return new ResponseEntity<List<Bid>>(res,HttpStatus.FOUND);
	}
	
	@PutMapping("/bids/{Id}")
	public ResponseEntity<Bid> updateBidStatusHandler(@PathVariable Integer Id, @RequestBody String bidStatus) throws Exception{
		Bid res = bidService.updateBidStatus(Id, bidStatus);
		return new ResponseEntity<Bid>(res,HttpStatus.ACCEPTED);
	}
}
