package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.NotFoundException;
import com.masai.model.Bid;
import com.masai.service.BidService;

@RestController
public class BidController {
	
	@Autowired
	private BidService bService;
	
	@PostMapping("/Bids/")
	public ResponseEntity<Bid> saveBidRecord(@RequestBody Bid bid) throws Exception {
		Bid res = bService.saveBidRecord(bid);
		return new ResponseEntity<Bid>(res,HttpStatus.CREATED);
	}
	
	@GetMapping("Bids/{vendorId}")
	public ResponseEntity<List<Bid>> fetchAllBidsByVendor(Integer vendorId) throws NotFoundException{
		List<Bid> res = bService.getAllBidsOfVendor(vendorId);
		return new ResponseEntity<List<Bid>>(res,HttpStatus.FOUND);
	}
}
