package com.wipro.rest.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.rest.jpa.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {

}
