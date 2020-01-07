package com.yuansong.study.mdd.dboperation.ymlconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.yuansong.study.mdd.common.config.DataSourceConfigFirst;
import com.yuansong.study.mdd.common.config.DataSourceConfigSecond;

@Component
public class DataSourcesBeanMultiple {
	
	@Autowired
	private DataSourceConfigFirst dataSourceConfigFirst;
	
	@Autowired
	private DataSourceConfigSecond dataSourceConfigSecond;

	@Autowired
	private DatasourceConfigHelper datasourceConfigHelper;
	
	@Bean(name="dsFirst")
	public DataSource dsFirst() {
		if(this.dataSourceConfigFirst != null) {
			return this.datasourceConfigHelper.getDataSourceByConfig(this.dataSourceConfigFirst);
		} else {
			return null;
		}
	}
	
	@Bean(name="jdbcTemplateFirst")
	public JdbcTemplate jdbcTemplateFirst(@Qualifier("dsFirst") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean(name="txManagerFirst")
	public PlatformTransactionManager txManagerFirst(@Qualifier("dsFirst") DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
	@Bean(name="dsSecond")
	public DataSource dsSecond() {
		if(this.dataSourceConfigSecond != null) {
			return this.datasourceConfigHelper.getDataSourceByConfig(this.dataSourceConfigSecond);
		} else {
			return null;
		}
	}
	
	@Bean(name="jdbcTemplateSecond")
	public JdbcTemplate jdbcTemplateSecond(@Qualifier("dsSecond") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean(name="txManagerSecond")
	public PlatformTransactionManager txManagerSecond(@Qualifier("dsSecond") DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
}
