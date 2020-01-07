package com.yuansong.study.mdd.dboperation.ymlconfig;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public interface DataSourcesTest {
	
	public Integer dbCount();
	
	public List<String> dbList();
	
	public String dbName();
	
	public void tranTest();
	
	public void insertTest();
	
	public void insertError();
	
	public JdbcTemplate getJdbcTemplate();

}
