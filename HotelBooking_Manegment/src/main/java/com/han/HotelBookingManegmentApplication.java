package com.han;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class HotelBookingManegmentApplication {

	public static void main(String[] args) {
		log.info("main method started");
		SpringApplication.run(HotelBookingManegmentApplication.class, args);
		
		log.info("main method stoped");
	}

}
