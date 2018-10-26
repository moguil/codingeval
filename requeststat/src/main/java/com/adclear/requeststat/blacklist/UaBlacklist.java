package com.adclear.requeststat.blacklist;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UaBlacklist {
	@Id
	@NotNull
	private String ua;
	
	public String getUa() {
		return ua;
	}

}
