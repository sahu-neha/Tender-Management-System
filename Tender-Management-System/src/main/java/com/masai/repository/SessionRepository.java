package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentVendorSession;

public interface SessionRepository extends JpaRepository<CurrentVendorSession, Integer>{
	public CurrentVendorSession findByUuid(String uuid);
}
