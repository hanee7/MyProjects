package com.han.bean;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="HotelList")

public class HotelEntity implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
    @SequenceGenerator(name = "hotel_seq", sequenceName = "HOTEL_SEQ", allocationSize = 1)
    private Integer HotelId;
	
	@NonNull
	private String HotelName;
	
	@NonNull
	private String HotelAddress;
	
	@NonNull
	private Integer HotelTotalRooms;
	
	@NonNull
	private String HotelType;

}
