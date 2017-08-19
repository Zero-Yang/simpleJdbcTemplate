# SimpleJdbcTemplate
一个工程用来封装spring中的jdbcTemplate,用于简单的CRUD操作
示例:


spring中的配置文件

applicationContext.xml



	<!--开启注解处理器 -->
	<context:annotation-config />
	<context:component-scan base-package="com.java.*" />
	<!-- 数据驱动 -->
	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="${driver}"></property>
		<property name="url" value="${url}"></property>
		<property name="username" value="${username}"></property>
		<property name="password" value="${password}"></property>
	</bean>
	<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate"
		abstract="false" lazy-init="false" autowire="default">
		<property name="dataSource">
			<ref bean="dataSource" />
		</property>
	</bean>
		<bean id="jdbcTemplateProxy" class="com.java.jdbcTemplate.JdbcTemplateProxy">
		<property name="jdbcTemplate">
			<ref bean="jdbcTemplate" />
		</property>
	</bean>
	
	实现基本的CRUD功能
	
	
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