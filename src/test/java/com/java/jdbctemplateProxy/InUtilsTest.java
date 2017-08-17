package com.java.jdbctemplateProxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import com.java.jdbcTemplate.model.SqlParamsPairs;
import com.java.jdbcTemplate.utils.InUtils;

public class InUtilsTest {

	@Test
	public void testHandleIn() {
		String sql = "select * from t where a in ? and b = ? and c in ?";
		ArrayList<String> aps = new ArrayList<String>();
		aps.add("mike");
		aps.add("jimmy");
		aps.add("ted");
		
		ArrayList<String> cps = new ArrayList<String>();
		cps.add("kitty");
		cps.add("lily");
		cps.add("sara");
		Object[] params = new Object[]{aps,32,cps};
		SqlParamsPairs sqPairs = InUtils.handleIn(sql, params);
		
		assertThat(sqPairs.getSql(),is("select * from t where a in (?,?,?) and b = ? and c in (?,?,?)"));
		
		assertThat((String)sqPairs.getParams()[1],is("jimmy"));
		
		assertThat((String)sqPairs.getParams()[6],is("sara"));
	}
	
	@Test
	public void testHandleIn2(){
		String sql = "select * from t where a in ? and b = ? and c in ? and d = 2";
		ArrayList<String> aps = new ArrayList<String>();
		aps.add("mike");
		aps.add("jimmy");
		aps.add("ted");
		
		ArrayList<String> cps = new ArrayList<String>();
		cps.add("kitty");
		cps.add("lily");
		cps.add("sara");
		Object[] params = new Object[]{aps,32,cps};
		SqlParamsPairs sqPairs = InUtils.handleIn(sql, params);
		
		assertThat(sqPairs.getSql(),is("select * from t where a in (?,?,?) and b = ? and c in (?,?,?) and d = 2"));
		
		assertThat((String)sqPairs.getParams()[1],is("jimmy"));
		
		assertThat((String)sqPairs.getParams()[6],is("sara"));
	}

}
