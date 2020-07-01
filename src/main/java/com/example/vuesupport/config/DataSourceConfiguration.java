package com.example.vuesupport.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "datasource")
//@MapperScan(MapperScanbasePackages = DataSourceConfiguration.PACKAGE,sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class DataSourceConfiguration {

	static final String PACKAGE = "com.example.vuesupport.home.mapper";
	static final String MAPPER_LOCATION = "classpath:mapper/home/*.xml";
	static final String MAPPER_USER_LOCATION = "classpath:mapper/user/*.xml";


	private String driver;
	private String url;
	private String username;
	private String passwd;

	private int initialSize;
	private int minIdle;
	private int maxActive;
	private int maxWait;
	private int timeBetweenEvictionRunsMillis;
	private int minEvictableIdleTimeMillis;
	private String connectionProperties;
	private String validationQuery;
	private boolean testWhileIdle;
	private boolean testOnBorrow;
	private boolean testOnReturn;
	private String filters;

	@Bean
	public ServletRegistrationBean druidServlet(){
		return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
	}

	@Primary
	@Bean(name = "primaryDataSource")
	@Qualifier("primaryDataSource")
	public DataSource dataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(this.driver);
		dataSource.setUrl(this.url);
		dataSource.setUsername(this.username);
		dataSource.setPassword(this.passwd);
		dataSource.setMaxActive(this.maxActive);
		dataSource.setInitialSize(this.initialSize);
		dataSource.setMaxWait(this.maxWait);
		dataSource.setMinIdle(this.minIdle);
//		dataSource.setRemoveAbandoned(this.removeAbandoned);
//		dataSource.setRemoveAbandonedTimeout(this.removeAbandonedTimeout);
		dataSource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
		dataSource.setValidationQuery(this.validationQuery);
		dataSource.setTestWhileIdle(this.testWhileIdle);
		dataSource.setTestOnBorrow(this.testOnBorrow);
		dataSource.setTestOnReturn(this.testOnReturn);
		if (!StringUtils.isEmpty(this.filters))
		{
			dataSource.setFilters(filters);
		}
		dataSource.setConnectionProperties(this.connectionProperties);
		WallConfig wallConfig = new WallConfig();
		wallConfig.setMultiStatementAllow(true);
		WallFilter wallFilter = new WallFilter();
		wallFilter.setConfig(wallConfig);
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(wallFilter);
		dataSource.setProxyFilters(filters);
		return dataSource;
	}

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		try {
			return new JdbcTemplate(dataSource());
		} catch (SQLException e) {
		}
		return new JdbcTemplate();
	}

	@Bean(name = "masterTransactionManager")
	@Primary
	public DataSourceTransactionManager masterTransactionManager() throws SQLException{
		return new DataSourceTransactionManager(dataSource());
	}

	@Primary
	@Bean(name = "mysqlSqlSessionFactory")
	public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("primaryDataSource") DataSource basicDataSource) throws Exception {
		MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
		sessionFactory.setDataSource(basicDataSource);
		List<Resource> resources = new ArrayList<>();
		resources.addAll(Arrays.asList(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION)));
		resources.addAll(Arrays.asList(new PathMatchingResourcePatternResolver().getResources(MAPPER_USER_LOCATION)));
		sessionFactory.setMapperLocations(resources.toArray(new Resource[resources.size()]));
		sessionFactory.getObject().openSession();
		return sessionFactory.getObject();
	}


}
