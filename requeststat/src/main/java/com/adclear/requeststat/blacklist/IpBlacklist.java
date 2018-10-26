package com.adclear.requeststat.blacklist;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

@Entity
public class IpBlacklist {
	@Id
	@Positive
	private long ip;
	
	public long getIp() {
		return ip;
	}

}
