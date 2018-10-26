package com.adclear.requeststat.customer;

/*
 * Class used to get customer table at url /customers
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public List<Customer> retrieveAllUsers() {
		return customerRepository.findAll();
	}
	
}
