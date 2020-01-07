package com.yuansong.study.mdd.dboperation.ymlconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.yuansong.study.mdd.common.config.DataSourceConfigDefault;

@Component
public class DataSourcesBeanSingle {

	@Autowired
	private DataSourceConfigDefault dataSourceConfigDefault;
	
	@Autowired
	private DatasourceConfigHelper datasourceConfigHelper;
	
	@Bean(name="dsDefault")
	public DataSource dsDefault() {
		if(this.dataSourceConfigDefault != null) {
			return this.datasourceConfigHelper.getDataSourceByConfig(this.dataSourceConfigDefault);
		} else {
			return null;
		}
	}
	
	@Bean(name="jdbcTemplateDefault")
	@Primary
	public JdbcTemplate jdbcTemplateDefault(@Qualifier("dsDefault") DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
