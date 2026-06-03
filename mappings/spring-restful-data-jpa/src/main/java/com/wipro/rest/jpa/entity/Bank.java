package com.wipro.rest.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Bank")
public class Bank {
	
	@Id
	private long accountNumber;
    private String accountHolderName;
    private String bankName;
    private double balance;
    
    @OneToMany(
    	mappedBy = "customer",
    	cascade = CascadeType.ALL,
    	fetch = FetchType.LAZY
    )
    
    @JsonManagedReference
    private List<Loan> loans = new ArrayList<>();
    
    public Bank() {
    	
    }
    
	public Bank(long accountNumber, String accountHolderName, String bankName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		this.balance = balance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Bank [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", bankName="
				+ bankName + ", balance=" + balance + "]";
	}

}
