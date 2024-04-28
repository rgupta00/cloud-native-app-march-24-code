package com.bankapp.repo;

import com.bankapp.entities.Card;
import com.bankapp.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {
}
