package com.yuansong.study.mdd.dboperation.ymlconfig;

import javax.sql.DataSource;

import com.yuansong.study.mdd.common.config.DataSourceConfigAbstract;

public interface DatasourceConfigHelper {
	
	public <T extends DataSourceConfigAbstract> DataSource getDataSourceByConfig(T t);

}
