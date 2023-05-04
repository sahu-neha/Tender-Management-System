package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;
import com.masai.service.VendorService;

@RestController
public class VendorController {

	// This Method For Add New Vendor - @Author HoshiyarJyani

	@Autowired
	private VendorService vendorService;

	@PostMapping("/vendors")
	public ResponseEntity<Vendor> registerVendorHandler(@RequestBody Vendor vendor) {

		Vendor saveVendor = vendorService.createVendor(vendor);

		return new ResponseEntity<>(saveVendor, HttpStatus.CREATED);
	}

	// This Method for the Update the Vendor Details

	@PutMapping("/{username}/{password}/{newPassword}")
	public ResponseEntity<String> updateVendorPassword(@PathVariable("username") String username,
			@PathVariable("password") String password, @PathVariable("newPassword") String newPassword)
			throws VendorException {
		vendorService.updateVendorPassword(username, password, newPassword);
		return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
	}

	// This Method for get All List of Tenders Available by company

	@GetMapping("/tenders")
	public ResponseEntity<List<Tender>> getAllTenders() throws TenderException {
		List<Tender> tenders = vendorService.getAllTenders();
		if (tenders.size() == 0)
			throw new TenderException("Tender is not Available");
		return new ResponseEntity<>(tenders, HttpStatus.OK);
	}
   
	// This Method for the Place a Bid against a Tender.
	
	@PostMapping("/tenders/{tenderId}/bids")
	public ResponseEntity<String> placeBid(
	        @PathVariable Integer tenderId,
	        @RequestBody Bid bid) throws TenderException {
	    vendorService.placeBid(tenderId, bid);
	    return new ResponseEntity<>("Bid placed successfully", HttpStatus.CREATED);
	}
	
	
}
