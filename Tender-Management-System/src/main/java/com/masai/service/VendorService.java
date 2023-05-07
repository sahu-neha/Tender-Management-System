package com.masai.service;

import java.util.List;

import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.model.Bid;
import com.masai.model.Tender;
import com.masai.model.Vendor;

public interface VendorService {
	
	//This Method For Add New Vendor - @Author HoshiyarJyani
	public Vendor createVendor(Vendor vendor) throws VendorException;

	//This Method For change Password for Vendor - @Author HoshiyarJyani
	public void updateVendorPassword(String username,String password, String newPassword) throws VendorException;

	//This Method For Get The List Of All Tenders that are Available - @Author HoshiyarJyani
	public List<Tender> viewAllTenders() throws TenderException;

	//This Method for Place a bid by Vendor Againest a Tender
	public String placeBid(Integer tenderId,Integer vendorId, Bid bid) throws TenderException, VendorException;
	
	
}
