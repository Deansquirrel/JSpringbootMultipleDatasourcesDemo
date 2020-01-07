package com.yuansong.study.mdd.dboperation.ymlconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSourcesTestMultipleFirst extends DataSourcesTestAbstractImpl {
	
	@Autowired
	@Qualifier("jdbcTemplateFirst")
	private JdbcTemplate jdbcTemplate;

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

}
