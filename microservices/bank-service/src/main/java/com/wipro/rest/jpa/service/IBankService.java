package com.wipro.rest.jpa.service;

import java.util.List;

import com.wipro.rest.jpa.entity.Bank;

public interface IBankService {

    public Bank addBank(Bank bank);

    //public Bank updateBank(Bank bank);

    public Bank getByAccountNumber(long accNo);

    public void deleteByAccountNumber(long accNo);

    public List<Bank> getAllBanks();

    public Bank getByAccountHolderName(String name);

    public List<Bank> getByBalanceGT(double balance);
    
    
    public List<Bank> findAllBySorted();

    public int updateBalance(double balance, long accNo);

}

