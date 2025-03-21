package com.han.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.han.advice.UserNotfoundException;
import com.han.bean.UserEntity;
import com.han.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Service("UserService")
@Slf4j
public class UserServiceIMPL implements IUserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public String registerUser(UserEntity user) throws Exception{
		
		log.info("registerUser method processing");
		int val=repo.save(user).getUserId();
		
		log.info("registerUser method returning");
		return ("User Details Saaved ::"+val);
	}
	
	@Override
	public List<UserEntity> showAllUser() throws Exception{
		
		log.info("showAll method processing");
		List<UserEntity> list=repo.findAll();
		
		log.info("showAll method list");
		return list;
	}
	
	@Override
	public UserEntity showById(int id) throws Exception{
		
		log.info("showById method processing");
		return repo.findById(id).orElseThrow(()->new UserNotfoundException("Invalied Id.."));
	}
	
	
	
    private final RestTemplate restTemplate = new RestTemplate();
    
    @CircuitBreaker(name = "myService", fallbackMethod = "fallbackResponse")
    public String callExternalService() {
        // Simulating an external API call
        return restTemplate.getForObject("http://external-service/api/data", String.class);
    }

    // Fallback method when the external service fails
    public String fallbackResponse(Exception ex) {
        return "Fallback response: Service is temporarily unavailable.";
    }
}
