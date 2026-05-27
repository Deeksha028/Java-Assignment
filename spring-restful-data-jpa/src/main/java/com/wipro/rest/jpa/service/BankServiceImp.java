package com.wipro.rest.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.rest.jpa.entity.Bank;
import com.wipro.rest.jpa.repository.BankRepository;

@Transactional
@Service
public class BankServiceImp implements IBankService {

    @Autowired
    BankRepository repo;

    @Override
    public Bank addBank(Bank bank) {
        return repo.save(bank);
    }

//    @Override
//    public Bank updateBank(Bank bank) {
//        return repo.save(bank);
//    }

    @Override
    public Bank getByAccountNumber(int accNo) {
        return repo.findById(accNo).orElse(null);
    }

    @Override
    public void deleteByAccountNumber(int accNo) {
        repo.deleteById(accNo);
    }

    @Override
    public List<Bank> getAllBanks() {
        return repo.findAll();
    }

    @Override
    public Bank getByAccountHolderName(String name) {
        return repo.findByAccountHolderName(name);
    }

    @Override
    public List<Bank> getByBalanceGT(double balance) {
        return repo.findByBalanceGreaterThanOrderByAccountHolderNameAsc(balance);
    }
    
    @Override
    public List<Bank> findAllBySorted() {
        return repo.findAllBySorted();
    }

    @Override
    public int updateBalance(double balance, int accNo) {
        return repo.updateBalance(balance, accNo);
    }

}

