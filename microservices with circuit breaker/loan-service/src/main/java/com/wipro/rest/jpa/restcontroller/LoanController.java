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
import org.springframework.web.client.RestTemplate;

import com.wipro.rest.jpa.dto.Customer;
import com.wipro.rest.jpa.dto.LoanResponse;
import com.wipro.rest.jpa.entity.Loan;
import com.wipro.rest.jpa.service.ILoanService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	RestTemplate restTemplate;

    @Autowired
    ILoanService service;

    @PostMapping("/add")
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
        return ResponseEntity.ok(service.addLoan(loan));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Loan>> getAll() {
        return ResponseEntity.ok(service.getAllLoans());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Loan> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getLoanById(id));
    }
    
    @GetMapping("/customerloan/{loanid}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "customerFallback")
    public LoanResponse getLoanWithCustomer(@PathVariable("loanid") int loanId) {
    	Loan loan = service.getLoanById(loanId);
    	System.out.println(loan);
    	Customer customer = restTemplate.getForObject("http://API-GATEWAY/customer/get/"+loan.getCustomerId(),Customer.class);
    	return new LoanResponse(loan,customer);
    }
    
    public LoanResponse customerFallback(int loanId,Exception ex) {
    	Loan loan = service.getLoanById(loanId);
    	Customer customer = new Customer();
    	customer.setAccountNumber(0);
    	customer.setAccountHolderName("Customer Service Down");
    	customer.setBankName("N/A");
    	customer.setBalance(0);
    	return new LoanResponse(loan,customer);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteLoan(id);
        return "Loan Deleted";

    }

   
}
