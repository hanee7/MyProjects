package com.han.service;

import java.util.List;

import com.han.bean.HotelEntity;

public interface IHotelService {
 
	public String registerHotel(HotelEntity hotel) throws Exception;
	public List<HotelEntity> findAll() throws Exception;
	public HotelEntity findById(int HotelId) throws Exception;
	public String deleteAll() throws Exception;
	public String deleteById(int HotelId) throws Exception;
}
