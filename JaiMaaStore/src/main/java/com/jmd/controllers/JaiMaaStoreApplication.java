package com.jmd.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//@SpringBootApplication(scanBasePackages={"com.jmd.model","com.jmd.repository"}) 
public class JaiMaaStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaiMaaStoreApplication.class, args);
	}
}
