package com.masai.service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import com.masai.model.CurrentVendorSession;
import com.masai.model.LoginDTO;
import com.masai.model.Vendor;

public interface LoginService {
	public Vendor LogIntoAccount(String username,String password) throws Exception;

	public String LogOutFromAccount(String key) throws Exception;
}
