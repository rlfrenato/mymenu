package com.mymenu.customer.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mymenu.customer.model.Customer;
import com.mymenu.customer.model.Customer.CustomerStatus;
import com.mymenu.customer.repository.CustomerRepository;
import com.mysema.commons.lang.Assert;

@Component
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> getCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}
	
	public Customer getCustomerById(Long customerId) {
		
		Assert.notNull(customerId, "Customer ID can't be null");
		
		return customerRepository.findOne(customerId);
	}
	
	public List<Customer> getCustomerByBirthDate(Date birthDate) {
				
		return customerRepository.findByBirthDate(birthDate);
	}
	
	public Customer activateCustomer(Long customerId) {
		Customer customer = getCustomerById(customerId);
		customer.setStatus(CustomerStatus.ACTIVE);
		
		return customerRepository.save(customer);
	}
	
	public Customer deactivateCustomer(Long customerId) {
		Customer customer = getCustomerById(customerId);
		customer.setStatus(CustomerStatus.INACTIVE);
		
		return customerRepository.save(customer);
	}


}
