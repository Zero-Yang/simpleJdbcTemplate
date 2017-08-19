package com.java.jdbctemplateProxy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.java.jdbcTemplate.JdbcTemplateProxy;
import com.java.jdbcTemplate.exception.NoColumnAnnotationFoundException;
import com.java.jdbcTemplate.exception.NoIdAnnotationFoundException;
import com.simpleJdbc.test.LogInfo;
import com.simpleJdbc.test.LoginInfoDaoImpl;
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
	@Test
	public void testSelectList(){
		String sql="select * from loginfo ";
		List<LogInfo> selectList = jdbcTemplateProxy.selectList(sql, new Object[]{}, LogInfo.class);
		System.out.println(selectList.size());
	}

	@Test
	public void testget() throws NoIdAnnotationFoundException, NoColumnAnnotationFoundException{
		LogInfo loginfo = jdbcTemplateProxy.get(LogInfo.class, "1");
		System.out.println(loginfo);
	}
	@Test
	public  void testUpdate() throws Exception{
		LogInfo loginfo =new LogInfo(1, "yang", "xxx", "1");
		jdbcTemplateProxy.update(loginfo);
		LogInfo loginfo2 = jdbcTemplateProxy.get(LogInfo.class, "1");
		System.out.println(loginfo2);
	}
	
	@Test
	public  void testInsert() throws Exception{
		LogInfo loginfo =new LogInfo(1, "yang", "xxx", "1");
		jdbcTemplateProxy.save(loginfo);
		LogInfo loginfo2 = jdbcTemplateProxy.get(LogInfo.class, "1");
		System.out.println(loginfo2);
	}

}
