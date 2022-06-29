package com.work.api.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.common.ErrorDto;
import com.work.entity.UserDto;
import com.work.repository.LoginRepository;

@RestController
@RequestMapping(path = "/api")
public class LoginApi {

	@Autowired
	LoginRepository loginRepository;
	
	@PostMapping(path = "/login")
	LoginResponse login(@RequestBody LoginRequest req) {
		LoginResponse res = new LoginResponse();
		if(req.userName==null || req.userName.equals("")||req.password==null || req.password.equals("")) {
			ErrorDto errorDto = new ErrorDto("ERROR01", "userName or password not null");
			res.error = errorDto;
			return res;
		}
		UserDto user = loginRepository.findUserByuserName(req.userName);
		if(user!=null) {
			 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			 if(passwordEncoder.matches(req.password, user.password)) {
				 createTokenJwt(req,res);
			 }else {
				 ErrorDto errorDto = new ErrorDto("ERROR02", "password wrong");
					res.error = errorDto;
					return res;
			 }
			 return res;
		}
		return null;
		
	}

	private void createTokenJwt(LoginRequest req, LoginResponse res) {
		// TODO Auto-generated method stub
		
	}
	
}
