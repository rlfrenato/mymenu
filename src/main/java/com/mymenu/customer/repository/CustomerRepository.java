package com.mymenu.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.mymenu.customer.model.Customer;
import java.util.Date;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {	
	
	List<Customer> findByBirthDate(Date birthdate);
	List<Customer> findByEmail(String email);

}
