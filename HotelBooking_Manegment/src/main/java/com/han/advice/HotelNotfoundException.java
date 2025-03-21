package com.han.advice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HotelNotfoundException extends Exception{

	public HotelNotfoundException(String msg) {
		
		super(msg);
		log.error("Hotel Not found Exception");
	}
	public HotelNotfoundException() {
	  super();
	  log.error("Hotel Not found Exception");
	}
}
