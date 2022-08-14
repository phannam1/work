package com.work.api.work.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.common.ErrorDto;
import com.work.entity.WorkDto;
import com.work.repository.WorkRepository;

@RestController
@RequestMapping(value = "/api")
public class UpdateWorkProcess {
	@Autowired
	WorkRepository workrepository;

	@PutMapping(path = "/works/{id}")
	UpdateWorkResponse RegistWork(@RequestBody UpdateWorkRequest req, @PathVariable int id) {
		UpdateWorkResponse res = new UpdateWorkResponse();
		UpdateWork(res, req, id);
		return res;

	}

	private void UpdateWork(UpdateWorkResponse res,UpdateWorkRequest req,int id) {
		WorkDto WorkUpdate =  workrepository.findAllById(id);
		if(WorkUpdate!=null) {
			WorkUpdate.setWorkName(req.work.getWorkName());
			WorkUpdate.setStartingDate(req.work.getStartingDate());
			WorkUpdate.setEndingDate(req.work.getEndingDate());
			WorkUpdate.setStatus(req.work.getStatus());
			res.UpdateWork =workrepository.save(WorkUpdate);
		}else {
			ErrorDto error = new ErrorDto("ER001", "Work is not exits");
			res.error = error;
		}
		
	}
}
