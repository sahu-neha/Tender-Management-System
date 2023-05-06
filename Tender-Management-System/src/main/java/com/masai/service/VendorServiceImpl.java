
package com.masai.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;
import com.masai.repository.BidRepository;
import com.masai.repository.TenderRepository;
import com.masai.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private TenderRepository tenderRepository;
	
	@Autowired
	private BidRepository bidRepository;

	// This Method For Add New Vendor - @Author HoshiyarJyani
	@Override
	public Vendor createVendor(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	// This Method for Update The Password - @Author HoshiyarJyani
	@Override
	public void updateVendorPassword(String username, String password, String newPassword) throws VendorException {
		Optional<Vendor> optionalVendor = vendorRepository.findByUsername(username);
		if (optionalVendor.isPresent()) {
			Vendor vendor = optionalVendor.get();
			if (vendor.getPassword().equals(password)) {
				vendor.setPassword(newPassword);
				vendorRepository.save(vendor);
			} else {
				throw new VendorException("Password is incorrect.");
			}
		} else {
			throw new VendorException("Vendor not found with username: " + username);
		}
	}

	
	// This Method for getting the List of all available Tenders - @Author HoshiyarJyani
	@Override
	public List<Tender> viewAllTenders() throws TenderException {
	    List<Tender> allTenders = tenderRepository.findAll();

	    List<Tender> availableTenders = allTenders.stream()
	            .filter(tender -> "Available".equals(tender.getStatus())) 
	            .collect(Collectors.toList());

	    if (availableTenders.isEmpty()) {
	        throw new TenderException("No Tenders available");
	    } else {
	        return availableTenders;
	    }
	}



	// This Method for the Place a Bid against a Tender.

		@Override
		public String placeBid(Integer tenderId, Integer vendorId, Bid bid) throws TenderException, VendorException {
		    Optional<Tender> optionalTender = tenderRepository.findById(tenderId);
		    if (optionalTender.isPresent()) {
		        Tender tender = optionalTender.get();
		        
//		        if (!("AVAILABLE".equals(tender.getStatus()))) {
//		            throw new TenderException("Cannot place bid. Tender is not available.");
//		        }

		        Optional<Vendor> optionalVendor = vendorRepository.findById(vendorId);
		        if (optionalVendor.isPresent()) {
		            Vendor vendor = optionalVendor.get();
		            bid.setTender(tender);
		            bid.setVendor(vendor);
		            tender.getBidList().add(bid);
		            vendor.getBidList().add(bid);
		            bidRepository.save(bid);
		            tenderRepository.save(tender);
		            vendorRepository.save(vendor);
		        } else {
		            throw new VendorException("Vendor not found with ID: " + vendorId);
		        }
		    } else {
		        throw new TenderException("Tender not found with ID: " + tenderId);
		    }
		    return "Bid Placed Successfully. Your bid price is " + bid.getBidAmount() + ". Please wait for final approval by Admin.";
		}

}
