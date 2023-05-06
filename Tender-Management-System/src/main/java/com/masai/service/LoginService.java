package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.model.LoginDTO;

public interface LoginService {
	public String LogIntoAccount(LoginDTO dto) throws LoginException;

	public String LogOutFromAccount(String key) throws LoginException;
}
