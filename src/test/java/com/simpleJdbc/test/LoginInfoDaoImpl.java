package com.simpleJdbc.test;

import com.zero.simpleJdbc.SimpleJdbcTemplate;
public class LoginInfoDaoImpl implements LogInfoDao{
   
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	public LogInfo getLogInfo(int id) {
		String sql="select * from loginfo where id = ?";
		LogInfo logInfo = simpleJdbcTemplate.selectOne(sql, new Object[]{id}, LogInfo.class);
		return logInfo;
	}

	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}



}
