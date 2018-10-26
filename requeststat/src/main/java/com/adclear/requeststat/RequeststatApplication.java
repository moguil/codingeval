package com.adclear.requeststat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 
 * Starter files obtained with Spring boot
 * https://start.spring.io/
 * with Web, H2, JPA
 * 
 * The app uses H2 database, which is an in-memory database ! 
 * 
 */

@SpringBootApplication
public class RequeststatApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequeststatApplication.class, args);
	}
}
