package com.wipro.rest.jpa.service;

import java.util.List;

import com.wipro.rest.jpa.entity.Loan;

public interface ILoanService {
	
	public Loan addLoan(Loan loan);
	
	public List<Loan> getAllLoans();
	
	public Loan getLoanById(int id);
	
	public void deleteLoan(int id);
}

