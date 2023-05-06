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

import com.masai.exception.NotFoundException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;
import com.masai.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;

	/**
	 * This method adds a new vendor to the system.
	 *
	 * @param vendor The vendor object to be added
	 * @return A ResponseEntity object containing the saved vendor and HTTP status
	 *         code CREATED
	 * @Author HoshiyarJyani
	 */
	@PostMapping("/vendors")
	public ResponseEntity<Vendor> registerVendorHandler(@RequestBody Vendor vendor) {
		Vendor savedVendor = vendorService.createVendor(vendor);
		return new ResponseEntity<>(savedVendor, HttpStatus.CREATED);
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
	@PutMapping("/{username}/{password}/{newPassword}")
	public ResponseEntity<String> updateVendorPassword(@PathVariable("username") String username,
			@PathVariable("password") String password, @PathVariable("newPassword") String newPassword)
			throws VendorException {
		vendorService.updateVendorPassword(username, password, newPassword);
		return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
	}

	/**
	 * This method retrieves a list of all available tenders.
	 *
	 * @return A ResponseEntity object containing the list of tenders and HTTP
	 *         status code OK
	 * @throws TenderException If no tenders are available
	 * @Author HoshiyarJyani
	 */
	@GetMapping("/availabletenders")
	public ResponseEntity<List<Tender>> getAllTenders() throws TenderException {
		List<Tender> tenders = vendorService.viewAllTenders();
		if (tenders.size() == 0) {
			throw new TenderException("Tenders are not available");
		}
		return new ResponseEntity<>(tenders, HttpStatus.OK);
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
	@GetMapping("/availableTenders/{id}")
	public ResponseEntity<Tender> viewTendersByIdHandler(@PathVariable("id") Integer id)
			throws TenderException, NotFoundException {

		Tender tender = vendorService.viewTendersById(id);

		return new ResponseEntity<>(tender, HttpStatus.FOUND);

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
	@PostMapping("/tenders/{tenderId}/{vendorId}")
	public ResponseEntity<String> placeBid(@PathVariable Integer tenderId, @PathVariable Integer vendorId,
			@RequestBody Bid bid) throws TenderException, VendorException {
		vendorService.placeBid(tenderId, vendorId, bid);
		return new ResponseEntity<>("Bid placed successfully", HttpStatus.CREATED);
	}

	/**
	 * This method retrieves the bid history of a vendor by vendorId.
	 *
	 * @param vendorId The vendorId of the vendor whose bid history is to be
	 *                 retrieved
	 * @return A ResponseEntity object containing the list of bids made by the
	 *         vendor and HTTP status code OK
	 * @throws VendorException 
	 * @throws NotFoundException 
	 * @Author HoshiyarJyani
	 */
	@GetMapping("/vendors/bidHistory/{vendorId}")
	public ResponseEntity<List<Bid>> viewBidHistoryHandler(@PathVariable Integer vendorId) throws NotFoundException, VendorException {
		List<Bid> bidHistory = vendorService.viewBidHistory(vendorId);
		return new ResponseEntity<>(bidHistory, HttpStatus.OK);
	}

}
