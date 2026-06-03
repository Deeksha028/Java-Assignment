package com.wipro.rest.jpa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rest.jpa.entity.Loan;
import com.wipro.rest.jpa.service.ILoanService;

@RestController
@RequestMapping("/api/loan")
public class LoanRestController {
	
	@Autowired
	ILoanService service;
	
	@PostMapping("/add")
    public ResponseEntity<Loan> addBank(@RequestBody Loan loan) {
        return ResponseEntity.ok(service.addLoan(loan));
    }
	
	@GetMapping("/get/{id}")
    public ResponseEntity<Loan> getLoan(@PathVariable int id) {
        return ResponseEntity.ok(service.getLoanById(id));
    }
	
	@GetMapping("/getall")
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(service.getAllLoans());
    }
	
	@DeleteMapping("/delete/{id}")
    public String deleteLoan(@PathVariable int id) {
        service.deleteLoan(id);
        return "Loan Deleted";

    }

}
