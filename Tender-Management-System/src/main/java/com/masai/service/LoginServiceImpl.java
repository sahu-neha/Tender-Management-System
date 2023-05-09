package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.CurrentVendorSession;
import com.masai.model.LoginDTO;
import com.masai.model.Vendor;
import com.masai.repository.SessionRepository;
import com.masai.repository.VendorRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Vendor LogIntoAccount(String username, String password) throws Exception {
		System.out.println(username + " " + password);
		Optional<Vendor> existingVendor = vendorRepository.findByUsername(username);
		if (!existingVendor.isPresent()) {
		throw new Exception("Please Enter valid UserName");
		}
		// Optional<CurrentVendorSession> validVendorSession = sessionRepository
		// .findById(existingVendor.get().getVendorId());
		// if (validVendorSession.isPresent()) {
		// throw new LoginException("Vendor Already logged in with this username");
		// }
		if (existingVendor.get().getPassword().equals(password)) {
			return existingVendor.get();
			// CurrentVendorSession currentVendorSession = new
			// CurrentVendorSession(existingVendor.get().getVendorId(),
			// key, LocalDateTime.now());
			// sessionRepository.save(currentVendorSession);
			// return currentVendorSession.toString();
		} else {
			throw new Exception("Please Enter valid Password");
		}

	}

	@Override
	public String LogOutFromAccount(String key) throws Exception {
		CurrentVendorSession validVendorSession = sessionRepository.findByUuid(key);
		if (validVendorSession == null) {
			throw new Exception("User not Logged in with this UserName");
		}
		sessionRepository.delete(validVendorSession);
		return "Logged Out";
	}
}
