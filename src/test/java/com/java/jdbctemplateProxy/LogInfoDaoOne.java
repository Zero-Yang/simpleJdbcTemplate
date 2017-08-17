package com.java.jdbctemplateProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.jdbcTemplate.JdbcTemplateProxy;
import com.simpleJdbc.test.LogInfo;

@Repository
public class LogInfoDaoOne {

	@Autowired
	private JdbcTemplateProxy jdbcTemplateProxy;

	public void selectLogInfo() {
		String sql = "select * from loginfo where id= ?";
		LogInfo loginfo = jdbcTemplateProxy.selectOne(sql, new Object[] { 1 },
				LogInfo.class);
		System.out.println(loginfo);
	}

	public JdbcTemplateProxy getJdbcTemplateProxy() {
		return jdbcTemplateProxy;
	}

	public void setJdbcTemplateProxy(JdbcTemplateProxy jdbcTemplateProxy) {
		this.jdbcTemplateProxy = jdbcTemplateProxy;
	}
	
	
}
