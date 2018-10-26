package com.adclear.requeststat.request;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adclear.requeststat.blacklist.IpBlacklistRepository;
import com.adclear.requeststat.blacklist.UaBlacklistRepository;
import com.adclear.requeststat.customer.Customer;
import com.adclear.requeststat.customer.CustomerRepository;

/*
 * Class used to get hourly stat tables
 * and to put new request
 */

@RestController
public class RequestController {
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private IpBlacklistRepository ipBlacklistRepository;
	
	@Autowired
	private UaBlacklistRepository uaBlacklistRepository;
	
	//total nb of requests
	private long totalGlobal;
	
	//map: dayId -> number of requests
	public Map<Integer, Long> totalPerDay = new HashMap<>();
			
	//map: customerId -> number of requests
	public Map<Integer, Long> totalPerCustomer = new HashMap<>();
	
	
	//table of all request
	@GetMapping("/requests")
	public RequestPojo getHourlyStats() {
		List<HourlyStat> hs = requestRepository.findAll();
				
		return new RequestPojo(hs, totalGlobal);
	}	
	
	//table of all request for a specific day
	@GetMapping("/requests/days/{day}")
	public RequestPojo getHourlyStatsForDay(@PathVariable int day) {
		List<HourlyStat> hs = requestRepository.findByDay(day);
				
		return new RequestPojo(hs, totalPerDay.get(day));
	}
	
	//table of all request for a specific customer
	@GetMapping("/requests/customers/{customerID}")
	public RequestPojo getHourlyStatsForCustomer(@PathVariable int customerID) {
		List<HourlyStat> hs = requestRepository.findByCustomerID(customerID);
		
		return new RequestPojo(hs, totalPerCustomer.get(customerID));
	}
	
	//Put to create or update request
	@PutMapping("/requests")
	public ResponseEntity<Object> createPost(@RequestBody Request request) {
		
		// check if there is an entry for that HourlyStat id (customerId+hour)
		Optional<HourlyStat> hourlyStatOptional = requestRepository.findById(request.getHourlyStatID());
		HourlyStat hourlyStat;
		hourlyStat = (hourlyStatOptional.isPresent())?  hourlyStatOptional.get() : new HourlyStat(request);
		
		//check that the request is valid, that the customer is stored and active, that the Ip and user id are not blacklisted		
		if(request.isValid() && customerIsActive(request.getCustomerID()) && ipNotOnBlacklist(request.getRemoteIP()) && uaNotOnBlacklist(request.getUserID())) {
			
			hourlyStat.incrementRequestCount();
			
			//StudFunction
			studFunction(request);
			
		} else {
			hourlyStat.incrementInvalidCount();
		}
		
		//save
		requestRepository.save(hourlyStat);

		//increment total of request on the request day and customerID and glocbal
		incrementTotals(request.getDay(), request.getCustomerID());

		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(hourlyStat.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	private void studFunction(Request request) {
		
	}

	//helper method to increment the the global total, total per day and total per customer
	private void incrementTotals(int day, int customer) {
		totalPerDay.putIfAbsent(day, 0L);
		totalPerDay.put(day, totalPerDay.get(day)+1);
		
		totalPerCustomer.putIfAbsent(customer, 0L);
		totalPerCustomer.put(customer, totalPerCustomer.get(customer)+1);
		
		totalGlobal++;
	}
	
	private boolean ipNotOnBlacklist(long ip) {
		return ipBlacklistRepository.getIp(ip) == null;
	}
	
	private boolean customerIsActive(int id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.isPresent() && customer.get().getActive() == 1;
	}
	
	private boolean uaNotOnBlacklist(String userID) {
		return uaBlacklistRepository.getUa(userID) == null;
	}
}



















