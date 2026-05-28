package com.wipro.rest.jpa.service;

import java.util.List;

import com.wipro.rest.jpa.entity.Customer;

public interface ICustomerService {

    public Customer addCustomer(Customer customer);
    public List<Customer> getAllCustomers();
    public Customer getCustomerById(long id);
    public void deleteCustomer(long id);

}

