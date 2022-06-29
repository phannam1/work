package com.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.entity.UserDto;

public interface LoginRepository extends JpaRepository<UserDto, Integer>{

	UserDto  findUserByuserName(String userName);


	
}
