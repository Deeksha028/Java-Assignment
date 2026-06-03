package com.wipro.rest.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.rest.jpa.entity.Loan;
import com.wipro.rest.jpa.repository.LoanRepository;

@Service
public class LoanServiceImpl implements ILoanService {
	
	@Autowired
	LoanRepository repo;
	
	@Override
	public Loan addLoan(Loan loan) {
		return repo.save(loan);
	}
	@Override
	public Loan getLoanById(int id) {
		return repo.findById(id).orElse(null);
	}
	@Override
	public List<Loan> getAllLoans(){
		return repo.findAll();
	}
	@Override
	public void deleteLoan(int id) {
		repo.deleteById(id);
	}

}
