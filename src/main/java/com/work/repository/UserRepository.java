package com.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.entity.UserDto;

public interface UserRepository extends JpaRepository<UserDto,Integer> {

	UserDto findAllByusername(String username);

}
