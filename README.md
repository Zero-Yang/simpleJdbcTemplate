# SimpleJdbcTemplate
一个工程用来封装spring中的jdbcTemplate,用于简单的CRUD操作
示例:
spring中的配置文件
applicationContext.xml
  <!--自己定义的simpleJdbcTemplate -->
	<bean id="simpleJdbcTemplate" class="com.zero.simpleJdbc.SimpleJdbcTemplate">
		<property name="jdbcTemplate">
			<ref bean="jdbcTemplate" />
		</property>
	</bean>
	<!-- 注入 simpleJdbcTemplate-->
	<bean id="logInfoDao" class="com.simpleJdbc.test.LoginInfoDaoImpl">
		<property name="simpleJdbcTemplate">
			<ref bean="simpleJdbcTemplate" />
		</property>
	</bean>
代码示例:

public class LoginInfoDaoImpl implements LogInfoDao{
   
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	public LogInfo getLogInfo(int id) {
		String sql="select * from loginfo where id = ?";
		LogInfo logInfo = simpleJdbcTemplate.selectOne(sql, new Object[]{id}, LogInfo.class);
		return logInfo;
	}

	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}
}
