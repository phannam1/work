package com.work.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.entity.UserDto;
import com.work.repository.UserRepository;

@RestController
@RequestMapping(value = "/api")
public class LoginApi {
	@Autowired
	UserRepository userRepository;

	@PostMapping(path = "/login")
	LoginResponse Login(@RequestBody LoginRequest req) {

		UserDto user = userRepository.findAllByusername(req.username);
		if(user!=null) {
			
		}
		return null;
	}

}
