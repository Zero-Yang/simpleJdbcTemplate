package com.java.jdbctemplateProxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestDao extends AbstractJUnit4SpringContextTests{
	
	
	@Autowired
	@Qualifier("logInfoDaoOne")
	private LogInfoDaoOne logInfoDaoOne;
	
	@Test
	public  void testLogInfoDao1(){
		logInfoDaoOne.selectLogInfo();
	}

	public LogInfoDaoOne getLogInfoDaoOne() {
		return logInfoDaoOne;
	}

	public void setLogInfoDaoOne(LogInfoDaoOne logInfoDaoOne) {
		this.logInfoDaoOne = logInfoDaoOne;
	}
	
	
	
}
