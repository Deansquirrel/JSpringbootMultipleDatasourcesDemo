package com.yuansong.study.mdd.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.study.mdd.dboperation.ymlconfig.DataSourcesTestMultipleTest;
import com.yuansong.study.mdd.dboperation.ymlconfig.DataSourcesTestSingle;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags= {"02 DbOperation"})
@RequestMapping("/dbOperation")
public class DbOperationController {
	
	private static final Logger logger = LoggerFactory.getLogger(DbOperationController.class);
	
//	@Autowired
//	private SingleDataSourcesTest singleDataSourcesTest;
//	
//	@Autowired
//	private MultipleDataSourcesTest multipleDataSourcesTest;
//	
//	@Autowired
//	private MultipleDataSourcesTestFirst multipleDataSourcesTestFirst;
//	
//	@Autowired
//	private MultipleDataSourcesTestSecond multipleDataSourcesTestSecond;
	
	@Autowired
	private DataSourcesTestSingle dataSourcesTestSingle;
	
	@Autowired
	private DataSourcesTestMultipleTest dataSourcesTestMultipleTest;
	
	
	@GetMapping("/ymlConfig/SingleDataSource/dbCount")
	@ApiOperation("dbCount")
	public String singleDbCount() {
		logger.debug("dbCount");
		return String.valueOf(this.dataSourcesTestSingle.dbCount());
	}
	
	@GetMapping("/ymlConfig/SingleDataSource/dbList")
	@ApiOperation("dbList")
	public String singleDbList() {
		logger.debug("dbList");
		StringBuilder sb = new StringBuilder();
		for(String str : this.dataSourcesTestSingle.dbList()) {
			if(sb.length() > 0) {
				sb.append(" | ");
			}
			sb.append(str);
		}
		return sb.toString();
	}
	
	@GetMapping("/ymlConfig/SingleDataSource/dbName")
	@ApiOperation("dbName")
	public String singleDbName() {
		logger.debug("dbName");
		return this.dataSourcesTestSingle.dbName();
	}
	
	@GetMapping("/ymlConfig/SingleDataSource/insertTest")
	@ApiOperation("insertTest")
	public String singleInsertTest() {
		logger.debug("insertTest");
		this.dataSourcesTestSingle.insertTest();
		return "OK";
	}
	
	@GetMapping("/ymlConfig/SingleDataSource/tranTest")
	@ApiOperation("tranTest")
	public String singleTranTest() {
		logger.debug("tranTest");
		this.dataSourcesTestSingle.tranTest();
		return "OK";
	}
	
//	@GetMapping("/ymlConfig/MultipleDataSource/dbCount")
//	@ApiOperation("dbCount")
//	public String multipleDbCount() {
//		logger.debug("dbCount");
//		return String.valueOf(this.multipleDataSourcesTest.dbCountFirst() + 
//				" - " + 
//				this.multipleDataSourcesTest.dbCountSecond());
//	}
//	
//	@GetMapping("/ymlConfig/MultipleDataSource/dbList")
//	@ApiOperation("dbList")
//	public String multipleDbList() {
//		logger.debug("dbList");
//		StringBuilder sb = new StringBuilder();
//		for(String str : this.multipleDataSourcesTest.dbListFirst()) {
//			if(sb.length() > 0) {
//				sb.append(" | ");
//			}
//			sb.append(str);
//		}
//		for(String str : this.multipleDataSourcesTest.dbListSecond()) {
//			if(sb.length() > 0) {
//				sb.append(" | ");
//			}
//			sb.append(str);
//		}
//		return sb.toString();
//	}
//	
	@GetMapping("/ymlConfig/MultipleDataSource/tranTest")
	@ApiOperation("tranTest")
	public String multipleTranTest() {
		this.dataSourcesTestMultipleTest.tranTest();
		return "OK";
	}
}
