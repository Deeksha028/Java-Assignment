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

import com.wipro.rest.jpa.entity.Customer;
import com.wipro.rest.jpa.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService service;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.addCustomer(customer));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getById(@PathVariable long id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        service.deleteCustomer(id);
        
        return "Customer Deleted";


    }
}
