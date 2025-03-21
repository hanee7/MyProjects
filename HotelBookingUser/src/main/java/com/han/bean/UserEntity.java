package com.han.bean;


import java.io.Serializable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@SuppressWarnings("serial")
@Entity
@Table(name="HotelUser")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable{

	@Id
	@SequenceGenerator(name="seq",sequenceName = "user_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq")
	private Integer UserId;
	
	@NonNull
	private String UserName;
	
	@NonNull
	private Long UserPhno;
	
	@NonNull
	private String Address;
	
	@NonNull
	@ManyToOne(targetEntity = HotelEntity.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "h_id",referencedColumnName ="HotelId")
	private HotelEntity hotel;
 
//	public UserEntity() {
//		System.out.println("UserEntity.UserEntity()-oparam");
//	}
//	
//	@Override
//	public String toString() {
//		return "UserEntity [UserId=" + UserId + ", UserName=" +UserName + ", UserPhno=" + UserPhno + ", Address=" + Address + "]";
//	}
}
