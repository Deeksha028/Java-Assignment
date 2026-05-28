package com.wipro.rest.jpa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rest.jpa.entity.Bank;
import com.wipro.rest.jpa.service.IBankService;

@RestController
@RequestMapping("/bank")
public class BankRestController {

    @Autowired
    IBankService service;

    @PostMapping("/add")
    public ResponseEntity<Bank> addBank(@RequestBody Bank bank) {
        return ResponseEntity.ok(service.addBank(bank));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Bank>> getAllBanks() {
        return ResponseEntity.ok(service.getAllBanks());
    }

    @GetMapping("/getbyaccno/{accNo}")
    public ResponseEntity<Bank> getByAccountNumber(@PathVariable int accNo) {
        return ResponseEntity.ok(service.getByAccountNumber(accNo));
    }

    @DeleteMapping("/delete/{accNo}")
    public ResponseEntity<String> deleteBank(@PathVariable int accNo) {
        service.deleteByAccountNumber(accNo);

        Bank bank = service.getByAccountNumber(accNo);

        if (bank == null) {
            return ResponseEntity.ok("Record Deleted Successfully");
        } else {
            return ResponseEntity.ok("Delete Failed");
        }
    }

   
    @GetMapping("/getbyname/{name}")
    public ResponseEntity<Bank> getByAccountHolderName(@PathVariable String name) {
        return ResponseEntity.ok(service.getByAccountHolderName(name));
    }

    
    @GetMapping("/getbybalancegt/{balance}")
    public ResponseEntity<List<Bank>> getByBalanceGT(@PathVariable double balance) {
        return ResponseEntity.ok(service.getByBalanceGT(balance));
    }

    
    @GetMapping("/getallsorted")
    public List<Bank> getAllBanksSorted() {
        return service.findAllBySorted();
    }

    
    @PutMapping("/updatebalance/{balance}/{accNo}")
    public String updateBalance(@PathVariable double balance, @PathVariable int accNo) {
        int count = service.updateBalance(balance, accNo);
        return count + " record updated";
    }
}
