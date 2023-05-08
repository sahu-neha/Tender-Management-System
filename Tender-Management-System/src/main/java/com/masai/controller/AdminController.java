package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.NotFoundException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.AssignDTO;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;
import com.masai.service.AdminService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// ---------------------------------------------------------------------- //
	// =========================== TENDER METHODS =========================== //
	// ---------------------------------------------------------------------- //

	// ========== A D D - N E W - T E N D E R ========== //

	/**
	 * This method adds a new tender to the system.
	 *
	 * @param tender : The tender object to be added
	 * @return A ResponseEntity object containing the saved tender and HTTP status
	 *         code OK
	 * @throws TenderException : If tender is already created
	 * @Author sahu-neha
	 */
	@PostMapping("/tenders")
	public ResponseEntity<Tender> registerTenderHandler(@Valid @RequestBody Tender tender) throws TenderException {

		Tender createdTender = adminService.createTender(tender);

		return new ResponseEntity<>(createdTender, HttpStatus.CREATED);

	}

	// ========== G E T - A L L - T E N D E R S ========== //

	/**
	 * This method retrieves a list of all tenders.
	 * 
	 * @return A ResponseEntity object containing the list of tenders and HTTP
	 *         status code OK
	 * @throws TenderException If no tender available
	 * @Author sahu-neha
	 */
	@GetMapping("/tenders")
	public ResponseEntity<List<Tender>> viewAllTendersHandler() throws TenderException, NotFoundException {

		List<Tender> tenders = adminService.viewAllTenders();

		if (tenders.size() == 0)
			throw new TenderException("No Tender Found");

		return new ResponseEntity<>(tenders, HttpStatus.OK);

	}

	// ========== G E T - T E N D E R - B Y - I D ========== //

	/**
	 * This method retrieves details of a tender found by ID.
	 * 
	 * @param tenderId : The tender id of the tender to be retrieved
	 * @return A ResponseEntity object containing the saved tender and HTTP status
	 *         code CREATED
	 * @throws TenderException, NotFoundException If no tender available with the id
	 * @Author sahu-neha
	 */
	@GetMapping("/tendersById/{id}")
	public ResponseEntity<Tender> viewTendersByIdHandler(@PathVariable("id") Integer id)
			throws TenderException, NotFoundException {

		Tender tender = adminService.viewTendersById(id);

		return new ResponseEntity<>(tender, HttpStatus.OK);

	}

	// ========== G E T - T E N D E R S - B Y - S T A T U S ========== //

	/**
	 * This method retrieves a list of all tenders by its status (AVAILABLE/BOOKED).
	 * 
	 * @param status : status (AVAILABLE/BOOKED) for which the record of tenders is
	 *               to be retrieved
	 * @return A ResponseEntity object containing the list of tenders and HTTP
	 *         status code OK
	 * @throws TenderException If no tender available
	 * @Author sahu-neha
	 */
	@GetMapping("/tendersByStatus/{status}")
	public ResponseEntity<List<Tender>> viewTendersByStatusHandler(@PathVariable("status") String status)
			throws TenderException, NotFoundException {

		List<Tender> tenders = adminService.viewTendersByStatus(status);

		return new ResponseEntity<>(tenders, HttpStatus.OK);

	}

	// ========== R E M O V E - E X I S T I N G - T E N D E R ========== //

	/**
	 * This method removes any tender, found by tender ID.
	 * 
	 * @param id: tender id of the tender which needs to be removed
	 * @return A ResponseEntity object containing the deleted tender and HTTP status
	 *         code OK
	 * @throws TenderException, NotFoundException If no tenders available
	 * @Author sahu-neha
	 */
	@DeleteMapping("/tenders/{id}")
	public ResponseEntity<Tender> removeTenderHandler(@PathVariable("id") Integer id)
			throws TenderException, NotFoundException {

		Tender tender = adminService.removeTender(id);

		return new ResponseEntity<>(tender, HttpStatus.OK);

	}

	// ========== U P D A T E - E X I S T I N G - T E N D E R ========== //

	/**
	 * This method updates any tender, found by tender ID.
	 * 
	 * @param id:    tender id of the tender which needs to be updated
	 * @param tender t: tender object which contains the data to update
	 * @return A ResponseEntity object containing the updated tender and HTTP status
	 *         code OK
	 * @throws TenderException, NotFoundException If no tenders available
	 * @Author sahu-neha
	 */
	@PutMapping("/updateTender/{id}")
	public ResponseEntity<Tender> updateTenderHandler(@PathVariable("id") Integer id, @RequestBody Tender t)
			throws TenderException, NotFoundException {

		Tender tender = adminService.updateTender(t, id);

		return new ResponseEntity<>(tender, HttpStatus.OK);

	}

	// ---------------------------------------------------------------------- //
	// =========================== VENDOR METHODS =========================== //
	// ---------------------------------------------------------------------- //

	// ========== G E T - A L L - V E N D O R S ========== //

	/**
	 * This method retrieves a list of all vendors.
	 * 
	 * @return A ResponseEntity object containing the list of vendors and HTTP
	 *         status code OK
	 * @throws VendorException, NotFoundException If no vendors available
	 * @Author sahu-neha
	 */
	@GetMapping("/vendors")
	public ResponseEntity<List<Vendor>> viewAllVendorsHandler() throws VendorException, NotFoundException {

		List<Vendor> vendors = adminService.viewAllVendors();

		if (vendors.size() == 0)
			throw new VendorException("No Vendor Found");

		return new ResponseEntity<>(vendors, HttpStatus.OK);

	}

	// ========== G E T - A C T I V E - V E N D O R S ========== //

	/**
	 * This method retrieves a list of all active vendors.
	 * 
	 * @return A ResponseEntity object containing the list of vendors and HTTP
	 *         status code OK
	 * @throws VendorException, NotFoundException If no vendors available
	 * @Author sahu-neha
	 */
	@GetMapping("/activeVendors")
	public ResponseEntity<List<Vendor>> viewActiveVendorsHandler() throws VendorException, NotFoundException {

		List<Vendor> vendors = adminService.viewActiveVendors();

		if (vendors.size() == 0)
			throw new VendorException("No Vendor Found");

		return new ResponseEntity<>(vendors, HttpStatus.OK);

	}

	// ========== D E A C T I V A T E - A - V E N D O R ========== //

	/**
	 * This method deactivates any vendor, found by vendor ID.
	 * 
	 * @param id: vendor id of the vendor which needs to be deactivated
	 * @return A ResponseEntity object containing the saved vendor and HTTP status
	 *         code OK
	 * @throws VendorException, NotFoundException If no vendors available
	 * @Author sahu-neha
	 */
	@PatchMapping("/deactivateVendor/{id}")
	public ResponseEntity<Vendor> deactivateVendorHandler(@PathVariable("id") Integer id)
			throws VendorException, NotFoundException {

		Vendor vendor = adminService.deactivateVendor(id);

		return new ResponseEntity<>(vendor, HttpStatus.OK);

	}

	// ===== B A N - A - V E N D O R - F R O M - A - T E N D E R - B I D ===== //

	/**
	 * This method bar any vendor from participating in bids, found by vendor ID.
	 * 
	 * @param id: vendor id of the vendor which needs to be barred
	 * @return A ResponseEntity object containing the saved vendor and HTTP status
	 *         code OK
	 * @throws VendorException, NotFoundException If no vendors available
	 * @Author sahu-neha
	 */
	@PatchMapping("/banVendorFromBidding/{id}")
	public ResponseEntity<Vendor> barVendorFromBiddingHandler(@PathVariable("id") Integer id)
			throws VendorException, NotFoundException {

		Vendor vendor = adminService.barAVendorFromATenderBid(id);

		return new ResponseEntity<>(vendor, HttpStatus.OK);

	}

	// ----------------------------------------------------------------------- //
	// =========================== BIDDING METHODS =========================== //
	// ----------------------------------------------------------------------- //

	// ========== A S S I G N - T E N D E R - T O - A - V E N D O R ========== //

	/**
	 * This method allows admin to assign any vendor to a particular tender.
	 * 
	 * @param ad : The AssignDTO object (tenderID, vendorID) to be added
	 * @return A ResponseEntity object containing the saved Bid and HTTP status code
	 *         OK
	 * @throws VendorException, NotFoundException If no vendors available
	 * @throws TenderException, NotFoundException If no tenders available
	 * @Author sahu-neha
	 */
	@PutMapping("/bid/assign")
	public ResponseEntity<Bid> assignTenderToVendorHandler(@RequestBody AssignDTO ad)
			throws VendorException, TenderException, NotFoundException {

		Bid bid = adminService.assignTenderToVendor(ad);

		return new ResponseEntity<>(bid, HttpStatus.OK);

	}

	// ========== G E T - A L L - B I D S - O F - A - T E N D E R ========== //

	/**
	 * This method retrieves details of all the bids for a tender, found by ID.
	 * 
	 * @param tenderId : The id of the tender for which bidding list is to be
	 *                 retrieved
	 * @return A ResponseEntity object containing list of retrieved Bids and HTTP
	 *         status code OK
	 * @throws TenderException, NotFoundException If no tender or no bids available
	 *                          with the id
	 * @Author sahu-neha
	 */
	@GetMapping("/tenders/bid/{tenderId}")
	public ResponseEntity<List<Bid>> viewAllBidsOfATenderHandler(@PathVariable Integer tenderId)
			throws NotFoundException, TenderException {

		List<Bid> bids = adminService.viewAllBidsOfATender(tenderId);

		return new ResponseEntity<>(bids, HttpStatus.OK);

	}

}
