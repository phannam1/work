package com.work.api.work.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.repository.WorkRepository;

@RestController
@RequestMapping(value = "/api")
public class AddWorkProcess {
	@Autowired
	WorkRepository workrepository;

	@PostMapping(path = "/regist" )
	 AddWorkResponse RegistWork(@RequestBody AddWorkRequest req) {
		AddWorkResponse res = new AddWorkResponse();
		res.NewWork = workrepository.save(req.work);
		return res;
		
	}
}
