package com.han.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.han.bean.HotelEntity;

@FeignClient(name="hotel-service")
public interface HotelServiceClient {

	@GetMapping("/hotel/{id}")
	public HotelEntity findByID(@PathVariable int id);
}
