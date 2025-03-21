package com.han.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.han.advice.HotelNotfoundException;
import com.han.bean.HotelEntity;
import com.han.repository.HotelRepository;

import lombok.extern.slf4j.Slf4j;

@Service("HotelService")
@Slf4j
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private HotelRepository repo;
    
	@Override
        public String registerHotel(HotelEntity hotel) throws Exception{
		
		log.info("starting the registerHotel method");
	    int val=repo.save(hotel).getHotelId();
	    
	    log.info("returning the result");
	    return ("The hotel has saved with id ::"+val);
      }
      
	@Override
	    public List<HotelEntity> findAll() throws Exception{
		
		log.info("starting the findAllmethod");
		List<HotelEntity> msg= repo.findAll();
		
		log.info("returning the result");
		return msg;
	}
	
	@Override
	    public HotelEntity findById(int HotelId) throws Exception{
		
		log.info("starting the findBYId method");
		return repo.findById(HotelId).orElseThrow(()->new HotelNotfoundException("Ivalied Id"));
	}
	
	@Override
      public String deleteAll() throws Exception{
		
		log.info("starting the deleteAll methos");
	  repo.deleteAll();
	  
	  log.info("returning the result");
	  return ("All Hotels data deleted...");
    }

      @Override
      public String deleteById(int HotelId) throws Exception{	
    	  
    	  log.info("starting the deleteById method");
	  repo.deleteById(HotelId);
	  
	  log.info("returning the result");
	  return (HotelId+"::Deleted");	
      }
	
}
