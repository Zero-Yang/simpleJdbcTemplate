package com.zero.simpleJdbc;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SimpleJdbcTemplate {
	private static final Log LOG = LogFactory.getLog(SimpleJdbcTemplate.class);
	
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public <T> List<T> selectList(String sql, Object[] params, Class<T> clazz) {
		List<T> list = null;
		try {
			if (params == null) {
				list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(
						clazz));
			} else {
				list = jdbcTemplate.query(sql, params,
						new BeanPropertyRowMapper<T>(clazz));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("selectList find exception" + e);
		}
		return list;
	}

	public <T> List<T> selectList(String sql, Class<T> clazz) {
		return selectList(sql, null, clazz);
	}

	public <T> T selectOne(String sql, Object[] params, Class<T> clazz) {
		List<T> list = this.<T> selectList(sql, params, clazz);
		if (list.size() == 1) {
			return list.get(0);
		} else if (list.size() > 1) {
			throw new RuntimeException(
					"Expected one result (or null) to be returned by selectOne(), but found: "
							+ list.size());
		} else {
			return null;
		}
	}

	public Map<String, Object> selectMap(String sql, Object[] params) {
		try {
			return jdbcTemplate.queryForMap(sql, params);
		} catch (DataAccessException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (Object p : params) {
				sb.append(p + " | ");
			}
			sb.append("]");
			LOG.error("Error SQL: " + sql + " Params: " + sb.toString());
			throw e;
		}
	}

	public Map<String, Object> selectMap(String sql) {
		return selectMap(sql, null);
	}
	
	
	
	
	
}
