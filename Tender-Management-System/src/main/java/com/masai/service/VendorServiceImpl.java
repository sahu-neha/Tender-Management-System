
package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;
import com.masai.repository.TenderRepository;
import com.masai.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private TenderRepository tenderRepository;

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

	// This Method for get the List of all available Tenders - @Author HoshiyarJyani
	@Override
	public List<Tender> getAllTenders() {
//		return vendorRepository.findAllTenders();
		return null;
	}

	// This Method for the Place a Bid against a Tender.

	@Override
	public String placeBid(Integer tenderId, Bid bid) throws TenderException {
		Optional<Tender> optionalTender = tenderRepository.findById(tenderId);
		if (optionalTender.isPresent()) {
			Tender tender = optionalTender.get();
			if (!tender.getStatus().equals("Available")) {
				throw new TenderException("Cannot place bid. Tender is not available.");
			}
			bid.setTender(tender);
			Vendor vendor = bid.getVendor();
			bid.setVendor(vendor);
			tender.getBidList().add(bid);
			tenderRepository.save(tender);
		} else {
			throw new TenderException("Tender not found with ID: " + tenderId);
		}
		return null;
	}

}
