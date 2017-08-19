package com.java.jdbctemplateProxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.java.jdbcTemplate.JdbcTemplateProxy;
import com.java.jdbcTemplate.exception.NoColumnAnnotationFoundException;
import com.java.jdbcTemplate.exception.NoIdAnnotationFoundException;

@ContextConfiguration(locations={"classpath:spring.xml"})
public class JdbcTemplateToolTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private JdbcTemplateProxy jdbcTemplateProxy;
    
	@Test
	public void testList() throws IOException, SQLException {
		List<Employee> es = jdbcTemplateProxy.selectList("select * from employee where age < ? order by id desc", new Object[]{30}, Employee.class);
		
		assertThat(new Integer(es.size()),is(2));
		
		assertThat(es.get(1).getName(),is("tim"));
	}

	@Test
	public void testCount() throws IOException, SQLException {
		int total = jdbcTemplateProxy.count("select count(1) from employee", null);
		assertThat(total,is(3));
	}

	@Test
	public void testGet() throws NoIdAnnotationFoundException, NoColumnAnnotationFoundException, IOException, SQLException {
		
		Employee e = jdbcTemplateProxy.get(Employee.class, 3);
		assertThat(e.getName(),is("jacob"));
	}


	@Test
	public void testUpdate() throws Exception {
		
		Employee e = jdbcTemplateProxy.get(Employee.class, 1);
		e.setAge(23);
		jdbcTemplateProxy.update(e);
	}

	@Test
	public void testBatchUpdate() throws SQLException, IOException {
		
		
		List<Object[]> params = new ArrayList<Object[]>();
		Object[] p1 = new Object[]{23,"jack"};
		params.add(p1);
		Object[] p2 = new Object[]{29,"tim"};
		params.add(p2);
		
		jdbcTemplateProxy.batchUpdate("update employee set age = ? where name = ?", params);
		
	}

	@Test
	public void testSave() throws Exception {
		
		
		Employee e = new Employee();
		e.setId(4);
		e.setName("billy");
		Date now = new Date();
		e.setJoinDate(new Timestamp(now.getTime()));
		e.setAge(33);
		
		jdbcTemplateProxy.save(e);
		
	}
	
	@Test
	public void testSaveWithoutSomeField() throws Exception {
		
		
		Student s = new Student();
		s.setName("michael");
		s.setNothing("nothing");
		jdbcTemplateProxy.save(s);
		
	}

	@Test
	public void testDelete() throws Exception {
		Employee e = new Employee();
		e.setId(1);
		jdbcTemplateProxy.delete(e);
	}

}
