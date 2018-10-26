package com.adclear.requeststat.blacklist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UaBlacklistController {
	
	@Autowired 
	UaBlacklistRepository uaBlacklistRepository;
	
	@GetMapping("/uablacklist")
	public List<UaBlacklist> getBlacklist() {
		return uaBlacklistRepository.findAll();					
	}	
	
}
