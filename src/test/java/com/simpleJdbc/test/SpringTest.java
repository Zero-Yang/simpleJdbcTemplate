package com.simpleJdbc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class SpringTest {
	
//	public static void main(String[] args) {
//	       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
//	       LogInfoDao logInfoDao=(LogInfoDao) context.getBean("logInfoDao");
//		   LogInfo logInfo = logInfoDao.getLogInfo(1);
//	       System.out.println(logInfo.toString());
//	}
	
	@Autowired
	LogInfoDao logInfoDao;
	
	@Test
	public void testLogInfoDao(){
		   LogInfo logInfo = logInfoDao.getLogInfo(1);
	       System.out.println(logInfo.toString());
	}
	
	
	
	public LogInfoDao getLogInfoDao() {
		return logInfoDao;
	}
	public void setLogInfoDao(LogInfoDao logInfoDao) {
		this.logInfoDao = logInfoDao;
	}
	
	
}
