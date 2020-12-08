package com.manipal.demo.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todos")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//@Column(length=50, name="userName")
	private String userName;
	private String description;
	private LocalDate endDate;
	private boolean isCompleted;
	
	public ToDo() {};
	public ToDo(int id, String userName, String description, LocalDate endDate, boolean isCompleted) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.endDate = endDate;
		this.isCompleted = isCompleted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	

}
