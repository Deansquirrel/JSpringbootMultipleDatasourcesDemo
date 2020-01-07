package com.yuansong.study.mdd.dboperation.ymlconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataSourcesTestMultipleTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DataSourcesTestMultipleTest.class);
	
	@Autowired
	private DataSourcesTestMultipleFirst dataSourcesTestMultipleFirst;
	
	@Autowired
	private DataSourcesTestMultipleSecond dataSourcesTestMultipleSecond;
	
	@Transactional(value="txManagerFirst")
	public void tranTest() {
		logger.debug("=========================================");
		logger.debug("tranTest");
		logger.debug(this.dataSourcesTestMultipleFirst.dbName());
		this.dataSourcesTestMultipleFirst.insertTest();
//		this.dataSourcesTestMultipleFirst.insertError();
		this.dataSourcesTestMultipleSecond.insertTest();
		logger.debug("=========================================");
	}

}
