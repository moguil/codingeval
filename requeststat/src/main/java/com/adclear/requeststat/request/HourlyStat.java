package com.adclear.requeststat.request;

/*
 * Class used to  store statistics per customer per hour
 * 
 * hour is the nb of hours since start of Epoch time, so each hour is a unique number * 
 * Id is build by appending the hour to customer, which gives unique if for the pair customer, hour.
 * 
 * Like hour, day is the number of says since start of Epoch time
 */

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public  class HourlyStat {
	
	@Id
	private int id;
		
	private int customerId;
		
	private int day;
	
	private int hour;
	
	private long requestCount;
	
	private long invalidCount;
	
	public HourlyStat() {}
	
	public HourlyStat(Request request) {
		
		this.id = request.getHourlyStatID();
		
		this.customerId = request.getCustomerID();
				
		this.hour = request.getHour();
				
		this.day = request.getDay();		
			
		requestCount = 0L;
		
		invalidCount = 0L;
	}

	public int getId() {
		return id;
	}

	public int getCustomerId() {
		return customerId;
	}
	
	public int getDay() {
		return day;
	}
	
	//returns a human readable date + hour
	public String getHour() {
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT )
			                     .withLocale( Locale.GERMAN )
			                     .withZone( ZoneId.systemDefault() );
		Instant instant =  Instant.ofEpochSecond ((long) hour * 3600);
		return formatter.format( instant );
	}

	public long getRequestCount() {
		return requestCount;
	}

	public long getInvalidCount() {
		return invalidCount;
	}
	
	public void incrementRequestCount(){
		requestCount++;
	}
	
	public void incrementInvalidCount() {
		invalidCount++;
	}
}
