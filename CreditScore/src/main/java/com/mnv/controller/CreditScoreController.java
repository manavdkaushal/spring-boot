package com.mnv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mnv.model.CreditScore;
import com.mnv.repo.CreditScoreRepo;

@RestController
public class CreditScoreController 
{
	@Autowired
	CreditScoreRepo creditScoreRepo;
	
	@GetMapping("/creditScore/{ssn}")
	public CreditScore getScore(@PathVariable("ssn") String ssn) {
		return creditScoreRepo.findById(ssn).get();
	}
}
