package com.mnv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnv.model.CreditCard;

public interface CreditCardRepo extends JpaRepository<CreditCard, String> {

}
