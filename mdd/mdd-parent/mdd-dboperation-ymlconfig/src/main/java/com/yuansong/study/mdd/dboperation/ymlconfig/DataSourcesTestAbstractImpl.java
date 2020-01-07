package com.yuansong.study.mdd.dboperation.ymlconfig;

import java.util.List;

import com.yuansong.tools.common.CommonTool;
import com.yuansong.tools.common.DateTool;

public abstract class DataSourcesTestAbstractImpl implements DataSourcesTest {

	private static final String SQL_DbCount = "SELECT COUNT(*) FROM master..sysdatabases";
	private static final String SQL_DbList = "SELECT name FROM master..sysdatabases";
	private static final String SQL_DbName = "SELECT db_name()";
	// CREATE TABLE [a_test_cungno]([cungno] [nvarchar](300) primary key)
//	private static final String SQL_InsertTest = "";

	@Override
	public Integer dbCount() {
		return this.getJdbcTemplate().queryForObject(SQL_DbCount, Integer.class);
	}

	@Override
	public List<String> dbList() {
		return this.getJdbcTemplate().queryForList(SQL_DbList, String.class);
	}

	@Override
	public String dbName() {
		return this.getJdbcTemplate().queryForObject(SQL_DbName, String.class);
	}
	
	@Override
	public void tranTest() {
		this.insertTest();
		this.insertError();
	}

	@Override
	public void insertTest() {
		CommonTool ct = new CommonTool();
		DateTool dt = new DateTool();
		this.getJdbcTemplate().update("INSERT INTO [a_test_cungno](cungno)\n"
				+ "SELECT 'TEST-1 " + ct.UUID().replace("-", "") + " " + dt.GetDatetimeWithMillionsecond() + "'");
	}

	@Override
	public void insertError() {
		throw new RuntimeException("insert error");
	}

}
