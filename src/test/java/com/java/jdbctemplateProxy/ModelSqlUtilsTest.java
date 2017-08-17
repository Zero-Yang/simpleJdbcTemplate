package com.java.jdbctemplateProxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.java.jdbcTemplate.exception.NoColumnAnnotationFoundException;
import com.java.jdbcTemplate.exception.NoIdAnnotationFoundException;
import com.java.jdbcTemplate.model.SqlParamsPairs;
import com.java.jdbcTemplate.utils.ModelSqlUtils;

public class ModelSqlUtilsTest {

	@Test
	public void testGetGetFromObject() throws NoIdAnnotationFoundException, NoColumnAnnotationFoundException {
		
		SqlParamsPairs sqlAndParams = ModelSqlUtils.getGetFromObject(Employee.class, 3);
		
		assertThat(sqlAndParams.getSql(),is("select * from employee where id = ?"));
		
	}

}
