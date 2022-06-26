package com.work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_WORK")
public class WorkDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@Column(name = "WORKNAME", length = 50, nullable = true)
	public String WorkName;
	@Column(name = "STARTINGDATE", nullable = true)
	public String StartingDate;
	@Column(name = "ENDINGDATE", nullable = true)
	public String EndingDate;
	@Column(name = "STATUS", length = 10, nullable = true)
	public String Status;
	
	public WorkDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkDto(int id, String workName, String startingDate, String endingDate, String status) {
		super();
		this.id = id;
		WorkName = workName;
		StartingDate = startingDate;
		EndingDate = endingDate;
		Status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkName() {
		return WorkName;
	}
	public void setWorkName(String workName) {
		WorkName = workName;
	}
	public String getStartingDate() {
		return StartingDate;
	}
	public void setStartingDate(String startingDate) {
		StartingDate = startingDate;
	}
	public String getEndingDate() {
		return EndingDate;
	}
	public void setEndingDate(String endingDate) {
		EndingDate = endingDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
}
