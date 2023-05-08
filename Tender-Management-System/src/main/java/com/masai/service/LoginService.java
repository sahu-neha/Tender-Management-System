package com.masai.service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import com.masai.model.CurrentVendorSession;
import com.masai.model.LoginDTO;

public interface LoginService {
	public String LogIntoAccount(String username,String password) throws LoginException;

	public String LogOutFromAccount(String key) throws LoginException;
}
