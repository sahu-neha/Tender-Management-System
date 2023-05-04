package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.VendorException;
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
	public ResponseEntity<String> updateVendorPassword(
	        @PathVariable("username") String username,
	        @PathVariable("password") String password,
	        @PathVariable("newPassword") String newPassword) throws VendorException {
	    vendorService.updateVendorPassword(username, password, newPassword);
	    return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
	}

}
