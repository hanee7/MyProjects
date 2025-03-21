package com.han;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class HotelBookingApiGateWay {

	public static void main(String[] args) {
		
		log.debug("APIGate Way started");
		SpringApplication.run(HotelBookingApiGateWay.class, args);
		
		log.debug("APIGate Way stoped");

	}

}
