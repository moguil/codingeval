package com.adclear.requeststat.blacklist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IpBlacklistController {
	
	@Autowired 
	IpBlacklistRepository ipBlacklistRepository;
	
	@GetMapping("/ipblacklist")
	public List<IpBlacklist> getBlacklist() {
		return ipBlacklistRepository.findAll();					
	}	
	
}
