package com.java.jdbctemplateProxy;

import java.sql.Timestamp;

import com.java.jdbcTemplate.annotations.Column;
import com.java.jdbcTemplate.annotations.Id;

public class Employee {
	private Integer id;
	private String name;
	private Timestamp joinDate;
	private Integer age;
	
	@Id
	@Column
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
	
	@Column
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
