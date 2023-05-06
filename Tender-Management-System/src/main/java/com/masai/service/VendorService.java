package com.masai.service;

import java.util.List;

import com.masai.exception.NotFoundException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;

public interface VendorService {

	/**
	 * This method adds a new vendor to the system.
	 *
	 * @param vendor The vendor object to be added
	 * @return A ResponseEntity object containing the saved vendor and HTTP status
	 *         code CREATED
	 * @Author HoshiyarJyani
	 */
	public Vendor createVendor(Vendor vendor);

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
	public void updateVendorPassword(String username, String password, String newPassword) throws VendorException;

	/**
	 * This method retrieves a list of all available tenders.
	 *
	 * @return A ResponseEntity object containing the list of tenders and HTTP
	 *         status code OK
	 * @throws TenderException If no tenders are available
	 * @Author HoshiyarJyani
	 */
	public List<Tender> viewAllTenders() throws TenderException;

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
	public Tender viewTendersById(Integer tenderId) throws TenderException;

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
	public String placeBid(Integer tenderId, Integer vendorId, Bid bid) throws TenderException, VendorException;

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
	public List<Bid> viewBidHistory(Integer vendorId) throws NotFoundException, VendorException;

}
