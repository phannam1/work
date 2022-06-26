package com.work;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.work.entity.WorkDto;
import com.work.repository.WorkRepository;

@SpringBootTest

public class TestApi {

	@Autowired
	private WorkRepository workRepository;

	@Test
	public void TestApiGetAllListWorkOrderByReqSort() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("workname");
		arr.add("startingdate");
		arr.add("endingdate");
		arr.add("status");
		for (int i = 0; i < 4; i++) {
			String reqSort = arr.get(i);
			List<WorkDto> ListWork = workRepository.findAllListWorkOrderByReqSort(reqSort, 4);
			assertThat(ListWork != null && ListWork.size() <= 4);
		}

	}

	@Test
	public void TestApiAdd() {

		List<WorkDto> ListWorkCurent = workRepository.findAll();

		WorkDto work = new WorkDto(ListWorkCurent.size(), "Angular", "2022-01-01", "2022-12-01", "Pending");
		workRepository.save(work);
		List<WorkDto> ListWorkNew = workRepository.findAll();
		assertThat(ListWorkCurent.size() < ListWorkNew.size());

	}

	@Test
	public void TestApiUpdate() {

		WorkDto workCurrent = workRepository.findAllById(workRepository.findAll().size());
		WorkDto workUpdate = workRepository.findAllById(workRepository.findAll().size());
		workUpdate.setWorkName("C#");
		workRepository.save(workUpdate);
		WorkDto workAfterUpdate = workRepository.findAllById(workRepository.findAll().size());
		assertThat(!workCurrent.getWorkName().equals(workAfterUpdate.getWorkName()));

	}

	@Test
	public void TestApiDelete() {
		List<WorkDto> ListWorkCurent = workRepository.findAll();
		workRepository.deleteById(ListWorkCurent.size());
		List<WorkDto> ListWorkDelete = workRepository.findAll();
		assertThat(ListWorkCurent.size() > ListWorkDelete.size());

	}

}
