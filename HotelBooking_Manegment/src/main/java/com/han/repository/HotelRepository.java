package com.han.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.han.bean.HotelEntity;


public interface HotelRepository extends JpaRepository<HotelEntity, Integer>{

}
