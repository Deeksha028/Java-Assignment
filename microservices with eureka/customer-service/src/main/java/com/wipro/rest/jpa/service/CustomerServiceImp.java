package com.wipro.rest.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.rest.jpa.entity.Customer;
import com.wipro.rest.jpa.repository.CustomerRepository;

//@Transactional
@Service
public class CustomerServiceImp implements ICustomerService {

    @Autowired
    CustomerRepository repo;

    @Override
    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }     
    @Override
    public List<Customer> getAllCustomers(){
    	return repo.findAll();
    }
    
    @Override
    public Customer getCustomerById(long id) {
    	return repo.findById(id).orElse(null);
    }
    
    @Override
    public void deleteCustomer(long id) {
    	repo.deleteById(id);
        
    }

}

