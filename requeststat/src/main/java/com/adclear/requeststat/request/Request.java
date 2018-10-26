package com.adclear.requeststat.request;

import org.springframework.stereotype.Component;

/*
 * Class used to match the JSON request to be received
 * 
 * isValid() checks intern validity not if ip/ua is blacklisted, nor if customer is in DB and active
 * 
 * Class used as parameter for HourlyStat class constructor
 */

@Component
public class Request {
	
	private int customerID;
		
	private int tagID;
	
	private String userID;
		
	private String remoteIP;	
	
	private int timestamp;
	
	public Request() {}

	public Request(int customerID, int tagID, String userID, String remoteIP, int timestamp) {
		super();
		this.customerID = customerID;
		this.tagID = tagID;
		this.userID = userID;
		this.remoteIP = remoteIP;
		this.timestamp = timestamp;
	}

	public int getCustomerID() {
		return customerID;
	}

	public int getTagID() {
		return tagID;
	}

	public String getUserID() {
		return userID;
	}

	public long getRemoteIP() {
		remoteIP = remoteIP.replace(".", "");
		return Long.parseLong(remoteIP);
	}
	
	//in Epoch time seconds
	public int getTimestamp() {
		return timestamp;
	}
	
	//chek https://www.unixtimeconverter.io/ for test
	public int getHour() {
		return timestamp / 3600; 
	}
	
	public int getDay() {
		return getHour() / 24;		
	}
	
	//Hourly statID  = customer ID with hour of the request appended (hour is always 10 digits longth)
	public int getHourlyStatID() {		//
		return Integer.parseInt(getCustomerID() + "" + getHour());
	}
	
	@Override
	public String toString() {
		return "Request [customerID=" + customerID + ", tagID=" + tagID + ", userID=" + userID + ", remoteIP="
				+ remoteIP + ", timestamp=" + timestamp + "]";
	}
	
	public boolean isValid() {
		return customerIDisValid() && tagIDisValid() && userIDisValid() && remoteIPisValid() && timestampisValid();
	}
	
	private boolean customerIDisValid(){
		return customerID > 0;
	}
		
	private boolean tagIDisValid(){
		return tagID > 0;
	}
		
	private boolean userIDisValid(){
		return userID != null && !userID.equals("");
	}
	
	public boolean remoteIPisValid(){
		return remoteIP != null && remoteIP.length() >= 7;	//min length of a valid ip 1.1.1.1
	}	
		
	private boolean timestampisValid(){
		return timestamp > 1000000000; // 9 Sep 2001 03:46:40 		
	}
}






















