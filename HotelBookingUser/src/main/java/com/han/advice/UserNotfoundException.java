package com.han.advice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserNotfoundException extends RuntimeException{

	public UserNotfoundException(String msg) {
		super(msg);
		log.error("user not found exception handling");
	}
	public UserNotfoundException() {
	  super();
	    log.error("user not found exception handling");
	}
}
