package com.han.service;

import java.util.List;

import com.han.bean.UserEntity;

public interface IUserService {

	public String registerUser(UserEntity user) throws Exception;
	public List<UserEntity> showAllUser() throws Exception;
	public UserEntity showById(int id) throws Exception;
}
