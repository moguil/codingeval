package com.adclear.requeststat.request;

/*
 * Class used as return type of GET method of the controller
 * and automatically converted to JSON
 */

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RequestPojo {
	
	private long total;	

	private List<HourlyStat> hs;
	
	public RequestPojo() {}
	
	public RequestPojo(List<HourlyStat> hs, long total) {
		this.hs = hs;
		this.total = total;
	}
	
	public long getTotal() {
		return total;
	}

	public List<HourlyStat> getRequests() {
		return hs;
	}
		
}




