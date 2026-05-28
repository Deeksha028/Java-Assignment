package com.wipro.rest.jpa.dto;

import com.wipro.rest.jpa.entity.Loan;

public class LoanResponse {

	private Loan loan;
	private Customer customer;
	
	public LoanResponse() {
		
	}
	
	public LoanResponse(Loan loan, Customer customer) {
		super();
		this.loan = loan;
		this.customer = customer;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}

