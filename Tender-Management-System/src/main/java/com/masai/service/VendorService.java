package com.masai.service;

import com.masai.exception.VendorException;
import com.masai.model.Vendor;

public interface VendorService {
	
	//This Method For Add New Vendor - @Author HoshiyarJyani
	public Vendor createVendor(Vendor vendor);

	//This Method For Add New Vendor - @Author HoshiyarJyani
	public void updateVendorPassword(String username,String password, String newPassword) throws VendorException;
	
}
