package com.wipro.rest.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Loan")
public class Loan {
	
	@Id
	private int loanId;
    private String loanType;
    private String loanAmount;
    private long customerId;
    
	public Loan() {

	}
	

	public Loan(int loanId, String loanType, String loanAmount, long customerId) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.customerId = customerId;
	}
	

	public int getLoanId() {
		return loanId;
	}


	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}


	public String getLoanType() {
		return loanType;
	}


	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}


	public String getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}


	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanType=" + loanType + ", loanAmount=" + loanAmount + "]";
	}
    
    
}
