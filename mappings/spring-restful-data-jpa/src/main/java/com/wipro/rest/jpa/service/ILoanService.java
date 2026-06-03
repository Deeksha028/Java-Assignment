package com.wipro.rest.jpa.service;

import java.util.List;

import com.wipro.rest.jpa.entity.Loan;

public interface ILoanService {
	
	Loan addLoan(Loan loan);
	Loan getLoanById(int id);
	List<Loan> getAllLoans();
	void deleteLoan(int id);

}
