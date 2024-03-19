package com.mnv.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mnv.model.CreditScore;

public interface CreditScoreRepo extends JpaRepository<CreditScore, String>
{

}
