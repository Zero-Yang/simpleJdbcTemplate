package com.simpleJdbc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
	       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
	       LogInfoDao logInfoDao=(LogInfoDao) context.getBean("logInfoDao");
		   LogInfo logInfo = logInfoDao.getLogInfo(1);
	       System.out.println(logInfo.toString());
	}
}
