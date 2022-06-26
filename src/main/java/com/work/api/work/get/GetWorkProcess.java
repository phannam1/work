package com.work.api.work.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.repository.WorkRepository;

@RestController
@RequestMapping(value = "/api")
public class GetWorkProcess {
	@Autowired
	WorkRepository workrepository;

	@GetMapping(path = "/getall")
	GetWorkResponse RegistWork(@RequestBody GetWorkRequest req) {
		GetWorkResponse res = new GetWorkResponse();		
		res.ListWork = workrepository.findAllListWorkOrderByReqSort(req.ReqSort,req.ReqPagination);
		return res;

	}

	
}
