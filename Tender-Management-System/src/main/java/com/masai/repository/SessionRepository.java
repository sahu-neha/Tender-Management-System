package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentVendorSession;

@Repository
public interface SessionRepository extends JpaRepository<CurrentVendorSession, Integer>{
	public CurrentVendorSession findByUuid(String uuid);
}
