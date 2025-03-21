package com.han.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.han.bean.HotelEntity;
import com.han.service.IHotelService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/hotel")
@Slf4j
public class HotelController {
     
	@Autowired
	private IHotelService service;
	
	@PostMapping("/reg")
	public ResponseEntity<String> registerHotel(@RequestBody HotelEntity hotel) throws Exception{
		
		log.info("Accessing the service and registering the hotel");
		String result=service.registerHotel(hotel);
		
		log.info("returning the result");
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<HotelEntity>> showHotelList() throws Exception{
		
		log.info("Accessing the service and finding all the hotel details");
		List<HotelEntity> list=service.findAll();
		
		log.info("returning the list of hotels");
		return new ResponseEntity<List<HotelEntity>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HotelEntity> findById(@PathVariable int id) throws Exception{
		
		HotelEntity rs=service.findById(id);
		
		return new ResponseEntity<HotelEntity>(rs,HttpStatus.OK);
	}
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() throws Exception{
		
		log.info("Accessing the service to delete the hotel");
		service.deleteAll();
		
		log.info("returning the msg based on delete");
		return new ResponseEntity<String>("Hotel List is Deleted ..",HttpStatus.OK);
	}
	@DeleteMapping("/delete{id}")
	
	public ResponseEntity<String> deleteById(@PathVariable int id) throws Exception{
		
		log.info("Accessing the service to delete the hoted by id");
		service.deleteById(id);
		
		log.info("returned the msg of delete");
		return new ResponseEntity<String>(id+"-::this id recored is deleted",HttpStatus.OK);
	}
	
}
