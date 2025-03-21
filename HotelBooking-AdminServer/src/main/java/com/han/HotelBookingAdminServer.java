package com.han;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableAdminServer
@Slf4j
public class HotelBookingAdminServer {

	public static void main(String[] args) {
		log.debug("Admin Server Started");
		SpringApplication.run(HotelBookingAdminServer.class, args);
		log.debug("Admin server stoped");
	}

}
