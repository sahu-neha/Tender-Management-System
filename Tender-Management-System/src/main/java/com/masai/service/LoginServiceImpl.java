package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.model.CurrentVendorSession;
import com.masai.model.LoginDTO;
import com.masai.model.Vendor;
import com.masai.repository.SessionRepository;
import com.masai.repository.VendorRepository;

import net.bytebuddy.utility.RandomString;

public class LoginServiceImpl implements LoginService{

	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Override
	public String LogIntoAccount(LoginDTO dto) throws LoginException {
		Optional<Vendor> existingVendor = vendorRepository.findByUsername(dto.getUsername());
		if(existingVendor==null) {
			throw new LoginException("Please Enter valid UserName");
		}
		Optional<CurrentVendorSession> validVendorSessOpt = sessionRepository.findById(existingVendor.get().getVendorId());
		if(validVendorSessOpt.isPresent()) {
			throw new LoginException("Vendor Already logged in with this username");
		}
		if(existingVendor.get().getPassword().equals(dto.getPassword())) {
			 String key = RandomString.make(6);
			CurrentVendorSession currentVendorSession = new CurrentVendorSession(existingVendor.get().getVendorId(),key,LocalDateTime.now());
			sessionRepository.save(currentVendorSession);
			return currentVendorSession.toString();
		}else {
			throw new LoginException("Please Enter valid password");
		}
	}

	@Override
	public String LogOutFromAccount(String key) throws LoginException {
		CurrentVendorSession validVendorSession = sessionRepository.findByUuid(key);
		if(validVendorSession==null) {
			throw new LoginException("User not Logged in with this UserName");
		}
		sessionRepository.delete(validVendorSession);
		return "Logged Out";
	}
}
