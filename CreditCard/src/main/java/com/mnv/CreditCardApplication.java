package com.mnv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.mnv.repo.CreditCardRepo;

@SpringBootApplication
public class CreditCardApplication 
{	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CreditCardApplication.class, args);
	}

}
