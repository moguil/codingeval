package com.adclear.requeststat.customer;

/*
 * class used to access stored customer
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
