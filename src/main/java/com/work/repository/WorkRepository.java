package com.work.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.work.entity.WorkDto;

public interface WorkRepository extends JpaRepository<WorkDto, Integer>{

	WorkDto findAllById(int id);
	@Query(value="SELECT ID,ENDINGDATE,STARTINGDATE, STATUS, WORKNAME FROM TBL_WORK ORDER BY :ReqSort DESC LIMIT :ReqPagination" , nativeQuery = true)
	 List<WorkDto> findAllListWorkOrderByReqSort(@Param("ReqSort") String ReqSort,@Param("ReqPagination") int ReqPagination);

}
