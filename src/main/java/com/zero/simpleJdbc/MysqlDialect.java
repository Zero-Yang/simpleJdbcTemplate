package com.zero.simpleJdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MysqlDialect extends Dialect{

	private static final Log LOG = LogFactory.getLog(MysqlDialect.class);
	public static void forDialectSave(String tableName,Object obect){
		StringBuffer sb=new StringBuffer();
		sb.append("insert into");
		if(tableName!=null){
			sb.append(tableName);
		}else{
			sb.append(obect.getClass().getSimpleName());
		}
		//sb.append(b)
		LOG.info(sb.toString());
	}
	
}
