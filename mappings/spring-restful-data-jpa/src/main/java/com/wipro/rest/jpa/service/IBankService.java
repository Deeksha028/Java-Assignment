package com.wipro.rest.jpa.service;

import java.util.List;

import com.wipro.rest.jpa.entity.Bank;

public interface IBankService {

    public Bank addBank(Bank bank);

    //public Bank updateBank(Bank bank);

    public Bank getByAccountNumber(int accNo);

    public void deleteByAccountNumber(int accNo);

    public List<Bank> getAllBanks();

    public Bank getByAccountHolderName(String name);

    public List<Bank> getByBalanceGT(double balance);
    
    
    public List<Bank> findAllBySorted();

    public int updateBalance(double balance, int accNo);

}

