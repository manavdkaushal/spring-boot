package com.mnv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mnv.dto.CreditScore;
import com.mnv.model.CreditCard;
import com.mnv.repo.CreditCardRepo;

@RestController
public class CreditCardController 
{
	@Autowired 
	private CreditCardRepo creditCardRepo;
	
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/issueCard")
	public String issueCard(@RequestBody CreditCard creditCard) 
	{
		ResponseEntity<CreditScore> cs = restTemplate.getForEntity("http://localhost:8080/creditScore/"+ creditCard.getSsn(), CreditScore.class);
		
		if( creditCardRepo.findById(creditCard.getSsn()).isPresent() )
			return "Cannot re-issue Credit Card for - " + creditCard.getHolder_name();
		
		if( cs != null  &&  cs.getBody().getScore() >= 700 ) {
			creditCardRepo.save(creditCard);
			
			return "Credit Card issued successfully for - " + creditCard.getHolder_name();
		} else {
			return "*** Credit Card cannot be issued due to low Credit Score. *** ";
		}
		
	}
	
}
