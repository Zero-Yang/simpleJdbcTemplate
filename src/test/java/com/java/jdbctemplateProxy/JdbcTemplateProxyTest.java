package com.java.jdbctemplateProxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.java.jdbcTemplate.JdbcTemplateProxy;
import com.simpleJdbc.test.LogInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class JdbcTemplateProxyTest extends AbstractJUnit4SpringContextTests {
    
	@Autowired
	private JdbcTemplateProxy jdbcTemplateProxy;
     
	@Test
	public void testSetJdbcTemplate() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
		JdbcTemplateProxy jdbcTemplateProxy=(JdbcTemplateProxy) context.getBean("jdbcTemplateProxy");
	    System.out.println(jdbcTemplateProxy);
	    String sql="select * from loginfo where id= ?";
	    LogInfo loginfo = jdbcTemplateProxy.selectOne(sql, new Object[]{1}, LogInfo.class);
	    System.out.println(loginfo);
	}
	

	
	@Test
	public void testtemplate(){
	    String sql="select * from loginfo where id= ?";
	    LogInfo loginfo = jdbcTemplateProxy.selectOne(sql, new Object[]{1}, LogInfo.class);
	    System.out.println(loginfo);
	}

/*	public JdbcTemplateProxy getJdbcTemplateProxy() {
		return jdbcTemplateProxy;
	}

	public void setJdbcTemplateProxy(JdbcTemplateProxy jdbcTemplateProxy) {
		this.jdbcTemplateProxy = jdbcTemplateProxy;
	}*/


	
	
}
