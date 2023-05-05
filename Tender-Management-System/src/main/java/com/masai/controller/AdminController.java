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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.NotFoundException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
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

	@PostMapping("/tenders")
	public ResponseEntity<Tender> registerTenderHandler(@Valid @RequestBody Tender tender) throws TenderException {

		Tender createdTender = adminService.createTender(tender);
		return new ResponseEntity<>(createdTender, HttpStatus.CREATED);

	}

	// ========== G E T - A L L - T E N D E R S ========== //

	@GetMapping("/tenders")
	public ResponseEntity<List<Tender>> viewAllTendersHandler() throws TenderException, NotFoundException {

		List<Tender> tenders = adminService.viewAllTenders();

		if (tenders.size() == 0)
			throw new TenderException("No Tender Found");
		return new ResponseEntity<>(tenders, HttpStatus.FOUND);

	}

	// ========== G E T - T E N D E R - B Y - I D ========== //

	@GetMapping("/tendersById/{id}")
	public ResponseEntity<Tender> viewTendersByIdHandler(@PathVariable("id") Integer id)
			throws TenderException, NotFoundException {

		Tender tender = adminService.viewTendersById(id);
		return new ResponseEntity<>(tender, HttpStatus.FOUND);

	}

	// ========== G E T - T E N D E R S - B Y - S T A T U S ========== //

	@GetMapping("/tendersByStatus/{status}")
	public ResponseEntity<List<Tender>> viewTendersByStatusHandler(@PathVariable("status") String status)
			throws TenderException, NotFoundException {

		List<Tender> tenders = adminService.viewTendersByStatus(status);
		return new ResponseEntity<>(tenders, HttpStatus.FOUND);

	}

	// ========== R E M O V E - E X I S T I N G - T E N D E R ========== //

	@DeleteMapping("/tenders/{id}")
	public ResponseEntity<Tender> removeTenderHandler(@PathVariable("id") Integer id)
			throws TenderException, NotFoundException {

		Tender tender = adminService.removeTender(id);
		return new ResponseEntity<>(tender, HttpStatus.OK);

	}

	// ========== U P D A T E - E X I S T I N G - T E N D E R ========== //

	@PutMapping("/updateTender/{id}")
	public ResponseEntity<Tender> updateTenderHandler(@PathVariable("id") Integer id, @RequestBody Tender t)
			throws TenderException, NotFoundException {

		Tender tender = adminService.updateTender(t, id);
		return new ResponseEntity<>(tender, HttpStatus.ACCEPTED);

	}

	// ---------------------------------------------------------------------- //
	// =========================== VENDOR METHODS =========================== //
	// ---------------------------------------------------------------------- //

	// ========== D E A C T I V A T E - A - V E N D O R ========== //

	@PatchMapping("/deactivateVendor/{id}")
	public ResponseEntity<Vendor> deactivateVendorHandler(@PathVariable("id") Integer id)
			throws VendorException, NotFoundException {

		Vendor vendor = adminService.deactivateVendor(id);
		return new ResponseEntity<>(vendor, HttpStatus.ACCEPTED);

	}

	// ===== B A R - A - V E N D O R - F R O M - A - T E N D E R - B I D ===== //

	@PatchMapping("/barVendorFromBidding/{id}")
	public ResponseEntity<Vendor> barVendorFromBiddingHandler(@PathVariable("id") Integer id)
			throws VendorException, NotFoundException {

		Vendor vendor = adminService.deactivateVendor(id);
		return new ResponseEntity<>(vendor, HttpStatus.ACCEPTED);

	}

	// ----------------------------------------------------------------------- //
	// =========================== BIDDING METHODS =========================== //
	// ----------------------------------------------------------------------- //

	// ========== A S S I G N - T E N D E R - T O - A - V E N D O R ========== //

//	@PutMapping("/assign")
	
	
}
