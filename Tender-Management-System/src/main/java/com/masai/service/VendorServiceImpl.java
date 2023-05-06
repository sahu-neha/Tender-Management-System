
package com.masai.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NotFoundException;
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

	/**
	 * This method adds a new vendor to the system.
	 *
	 * @param vendor The vendor object to be added
	 * @return A ResponseEntity object containing the saved vendor and HTTP status
	 *         code CREATED
	 * @Author HoshiyarJyani
	 */
	@Override
	public Vendor createVendor(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	/**
	 * This method updates the password of a vendor.
	 *
	 * @param username    The username of the vendor
	 * @param password    The current password of the vendor
	 * @param newPassword The new password to be set
	 * @return A ResponseEntity object with the message "Password updated
	 *         successfully" and HTTP status code OK
	 * @throws VendorException If the vendor is not found or the password is
	 *                         incorrect
	 * @Author HoshiyarJyani
	 */
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

	/**
	 * This method retrieves a list of all available tenders.
	 *
	 * @return A ResponseEntity object containing the list of tenders and HTTP
	 *         status code OK
	 * @throws TenderException If no tenders are available
	 * @Author HoshiyarJyani
	 */
	@Override
	public List<Tender> viewAllTenders() throws TenderException {
		List<Tender> allTenders = tenderRepository.findAll();

		List<Tender> availableTenders = allTenders.stream().filter(tender -> "Available".equals(tender.getStatus()))
				.collect(Collectors.toList());

		if (availableTenders.isEmpty()) {
			throw new TenderException("No Tenders available");
		} else {
			return availableTenders;
		}
	}

	/**
	 * This method retrieves the details of a tender by tenderId.
	 *
	 * @param id The tenderId of the tender to retrieve
	 * @return A ResponseEntity object containing the tender and HTTP status code
	 *         FOUND
	 * @throws TenderException   If the tender is not available for bid
	 * @throws NotFoundException If the tender is not found
	 * @Author HoshiyarJyani
	 */
	@Override
	public Tender viewTendersById(Integer tenderId) throws TenderException {
		Optional<Tender> opt = tenderRepository.findById(tenderId);

		if (opt.isPresent()) {
			Tender viewTender = opt.get();
			if (viewTender.getStatus().toString().equalsIgnoreCase("available")) {
				return viewTender;
			} else {
				throw new TenderException("This Tender is not available for Bid");
			}
		} else {
			throw new TenderException("Tender not found");
		}
	}

	/**
	 * This method places a bid against a tender.
	 *
	 * @param tenderId The tenderId of the tender to place a bid against
	 * @param vendorId The vendorId of the vendor placing the bid
	 * @param bid      The Bid object containing the bid details
	 * @return A ResponseEntity object with the message "Bid placed successfully"
	 *         and HTTP status code CREATED
	 * @throws TenderException If the tender is not available for bid
	 * @throws VendorException If the vendor is not found or the bid amount is less
	 *                         than the current highest bid
	 * @Author HoshiyarJyani
	 */
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
		return "Bid Placed Successfully. Your bid price is " + bid.getBidAmount()
				+ ". Please wait for final approval by Admin.";
	}

	/**
	 * This method retrieves the bid history of a vendor by vendorId.
	 *
	 * @param vendorId The vendorId of the vendor whose bid history is to be
	 *                 retrieved
	 * @return A ResponseEntity object containing the list of bids made by the
	 *         vendor and HTTP status code OK
	 * @throws NotFoundException 
	 * @throws VendorException 
	 * @Author HoshiyarJyani
	 */
	@Override
	public List<Bid> viewBidHistory(Integer vendorId) throws NotFoundException, VendorException {
		Optional<Vendor> optionalVendor = vendorRepository.findById(vendorId);
		if (optionalVendor.isPresent()) {
			Vendor vendor = optionalVendor.get();
			List<Bid> bidList =  bidRepository.findBidHistoryByVendorId(vendorId);
			if(bidList.size()==0) {
				throw new NotFoundException("Bid Not Found");
			}
			return bidList;
		}else {
			throw new VendorException("Vendor Not Found with id "+vendorId);
		}
		
	}

}
