package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.TenderException;
import com.masai.model.Tender;
import com.masai.service.AdminService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/tenders")
public class TenderController {

	@Autowired
	private AdminService adminService;

	@PostMapping
	public ResponseEntity<Tender> registerTenderHandler(@Valid @RequestBody Tender tender) throws TenderException {
		
		Tender createdTender = adminService.createTender(tender);
		return new ResponseEntity<>(createdTender, HttpStatus.CREATED);
		
	}

	@GetMapping("/viewAllTenders")
	public ResponseEntity<List<Tender>> viewAllTendersHandler() throws TenderException {
		
		List<Tender> tenders = adminService.viewAllTenders();
		return new ResponseEntity<>(tenders, HttpStatus.OK);
		
	}

}
