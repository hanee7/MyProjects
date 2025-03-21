package com.han;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class HotelBookingEurekaServerApplication {

	public static void main(String[] args) {
		log.info("main method started");
		SpringApplication.run(HotelBookingEurekaServerApplication.class, args);
	
		log.info("main method stoped");
	}

}
