package com.mnv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mnv.model.CreditScore;
import com.mnv.repo.CreditScoreRepo;

@SpringBootTest
class CreditScoreApplicationTests 
{
	private final String ssnId = "10001";
	private final int score = 750;
	
	@Autowired
	CreditScoreRepo creditScoreRepo;
	
	
	
	@Test
	void testCreditScore() {
		CreditScore creditScore = creditScoreRepo.findById(ssnId).get();
		assertNotEquals(creditScore, null);
		assertEquals(creditScore.getSsn(), ssnId);
		assertEquals(creditScore.getScore(), score);
	}

}
