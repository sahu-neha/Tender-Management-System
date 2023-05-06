package com.masai.service;

import java.util.List;

import com.masai.exception.NotFoundException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.AssignDTO;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;

public interface AdminService {

	// ---------------------------------------------------------------------- //
	// =========================== TENDER METHODS =========================== //
	// ---------------------------------------------------------------------- //

	// ========== A D D - N E W - T E N D E R ========== //

	public Tender createTender(Tender tender) throws TenderException;

	// ========== R E M O V E - E X I S T I N G - T E N D E R ========== //

	public Tender removeTender(Integer tenderId) throws TenderException;

	// ========== U P D A T E - E X I S T I N G - T E N D E R ========== //

	public Tender updateTender(Tender tender, Integer id) throws TenderException;

	// ========== G E T - A L L - T E N D E R S ========== //

	public List<Tender> viewAllTenders() throws TenderException;

	// ========== G E T - T E N D E R - B Y - I D ========== //

	public Tender viewTendersById(Integer tenderId) throws TenderException;

	// ========== G E T - T E N D E R S - B Y - S T A T U S ========== //

	public List<Tender> viewTendersByStatus(String status) throws TenderException;

	// ---------------------------------------------------------------------- //
	// =========================== VENDOR METHODS =========================== //
	// ---------------------------------------------------------------------- //

	// ========== G E T - A L L - V E N D O R S ========== //

	public List<Vendor> viewAllVendors() throws VendorException;

	// ========== G E T - A C T I V E - V E N D O R S ========== //

	public List<Vendor> viewActiveVendors() throws VendorException;

	// ========== D E A C T I V A T E - A - V E N D O R ========== //

	public Vendor deactivateVendor(Integer vendorId) throws VendorException, NotFoundException;

	// ===== B A R - A - V E N D O R - F R O M - A - T E N D E R - B I D ===== //

	public Vendor barAVendorFromATenderBid(Integer vendorId) throws VendorException, NotFoundException;

	// ----------------------------------------------------------------------- //
	// =========================== BIDDING METHODS =========================== //
	// ----------------------------------------------------------------------- //

	// ========== A S S I G N - T E N D E R - T O - A - V E N D O R ========== //

	public Bid assignTenderToVendor(AssignDTO ad)
			throws VendorException, TenderException, NotFoundException;

	// ========== G E T - A L L - B I D S - O F - A - T E N D E R ========== //

	public List<Bid> viewAllBidsOfATender(Integer tenderId) throws TenderException, NotFoundException;

}
