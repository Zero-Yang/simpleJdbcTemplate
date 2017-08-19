package com.simpleJdbc.test;

import com.java.jdbcTemplate.annotations.Id;
import com.java.jdbcTemplate.annotations.Table;
@Table(name="loginfo")
public class LogInfo {
	private int id;
	
	private String name;
	
	private String error;
	
	private String status;
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LogInfo(int id, String name, String error, String status) {
		super();
		this.id = id;
		this.name = name;
		this.error = error;
		this.status = status;
	}


	@Override
	public String toString() {
		return "LogInfo [id=" + id + ", name=" + name + ", error=" + error
				+ ", status=" + status + "]";
	}

	public LogInfo() {
		super();
	}
}
