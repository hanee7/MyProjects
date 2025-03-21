package com.han.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.han.bean.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
