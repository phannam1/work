package com.work.api.work.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.common.ErrorDto;
import com.work.entity.WorkDto;
import com.work.repository.WorkRepository;

@RestController
@RequestMapping(value = "/api")
public class DeleteWorkProcess {
	@Autowired
	WorkRepository workrepository;

	@DeleteMapping(path = "/delete/{id}")
	DeleteWorkResponse RegistWork( @PathVariable int id) {
		DeleteWorkResponse res = new DeleteWorkResponse();
		WorkDto WorkUpdate =  workrepository.findAllById(id);
		if(WorkUpdate!=null) {
			workrepository.deleteById(id);
			ErrorDto error = new ErrorDto("ER002", "Delete Success!");
			res.error = error;
		}else {
			ErrorDto error = new ErrorDto("ER001", "Work is not exits");
			res.error = error;
		}
		
		return res;

	}

}
