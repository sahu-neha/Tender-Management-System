
package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VendorException;
import com.masai.model.Tender;
import com.masai.model.Vendor;
import com.masai.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository vendorRepository;

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
	    return vendorRepository.findAllTenders();
	}


}
