package com.masai.service;

import java.util.List;

import com.masai.exception.VendorException;
import com.masai.model.Tender;
import com.masai.model.Vendor;

public interface VendorService {
	
	//This Method For Add New Vendor - @Author HoshiyarJyani
	public Vendor createVendor(Vendor vendor);

	//This Method For change Password for Vendor - @Author HoshiyarJyani
	public void updateVendorPassword(String username,String password, String newPassword) throws VendorException;

	//This Method For Get The List Of All Tenders that are Available - @Author HoshiyarJyani
	public List<Tender> getAllTenders();
	
}
