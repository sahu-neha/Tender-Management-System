//package com.masai.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.masai.exception.DisputeException;
//import com.masai.model.Dispute;
//import com.masai.repository.DisputeRepository;
//
//@Service
//public class DisputeServiceImpl implements DisputeService {
//
//	@Autowired
//	private DisputeRepository disputeRepository;
//
//	// ========== A D D - N E W - D I S P U T E ========== //
//
//	@Override
//	public Dispute createDispute(Dispute dispute) throws DisputeException {
//
//		if (dispute == null) {
//			throw new DisputeException("Invalid Dispute Details");
//		}
//
//		Dispute saveDispute = disputeRepository.save(dispute);
//
//		return saveDispute;
//
//	}
//
//}
