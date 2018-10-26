package com.adclear.requeststat.customer;

/*
 * class to match the customer representation and store it
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//Map to 'customer' table
@Entity
public class Customer {
	
	//Primary key - auto-increment
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@Max(value = 1, message="'active' must be 1 or 2")
	@Min(value = 0, message="'active' must be 1 or 2")
	private int active;
	
	public Customer() {}

	public Customer(int id, String name, int active) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public int getActive() {
		return active;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", active=" + active + "]";
	}	
	
}
