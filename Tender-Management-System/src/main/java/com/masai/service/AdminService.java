package com.masai.service;

import java.util.List;

import com.masai.exception.TenderException;
import com.masai.model.Tender;

public interface AdminService {

	// ---------- A D D - N E W - T E N D E R ---------- //

	public Tender createTender(Tender tender) throws TenderException;

	// ---------- R E M O V E - E X I S T I N G - T E N D E R ---------- //

	public Tender removeTender(Integer tenderId) throws TenderException;

	// ---------- U P D A T E - E X I S T I N G - T E N D E R ---------- //

	public Tender updateTender(Tender tender, Integer id) throws TenderException;

	// ---------- G E T - A L L - T E N D E R S ---------- //

	public List<Tender> viewAllTenders() throws TenderException;

	// ---------- G E T - T E N D E R - B Y - I D ---------- //

	public Tender viewTendersById(Integer tenderId) throws TenderException;
	
	// ---------- G E T - T E N D E R S - B Y - S T A T U S ---------- //
	
	public List<Tender> viewTendersByStatus(String status) throws TenderException;

}
