//package com.simpleJdbc.test;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//public class LogInfoMapper implements RowMapper{
//
//	public Object mapRow(ResultSet set, int index) throws SQLException {
//		LogInfo loginfo=new LogInfo(set.getInt("id"), set.getString("name"), set.getString("error"), set.getString("status"));
//		return loginfo;
//	}
//
//}
