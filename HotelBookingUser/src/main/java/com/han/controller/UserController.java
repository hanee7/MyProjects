package com.han.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.han.bean.HotelEntity;
import com.han.bean.UserEntity;
import com.han.client.HotelServiceClient;
import com.han.service.IUserService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	@Autowired
	private HotelServiceClient hotelService;
	
	@Autowired
	private IUserService userService;

	@PostMapping("/add")
	public ResponseEntity<String> registerUser(@RequestBody UserEntity user) throws Exception{
 
		log.info("registration processing");
		int id=user.getHotel().getHotelId();
		
		log.info("registration process finding client data");
		HotelEntity hotel=hotelService.findByID(id);
	
		log.info("registration process add client data to user");
		user.setHotel(hotel);
		
		log.info("registration process");
		String msg=userService.registerUser(user);
		
		log.info("registration process returning");
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserEntity>> showAllUser()throws Exception{
		
		log.info("showAll method processing");
		List<UserEntity> list=userService.showAllUser();
		
		log.info("showAll method returning");
		return new ResponseEntity<List<UserEntity>>(list,HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> ShowById(@PathVariable int id)throws Exception{
    	
    	log.info("showById method processing");
    	UserEntity user=userService.showById(id);
    	
    	log.info("showById method returning");
    	return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
    }
}
