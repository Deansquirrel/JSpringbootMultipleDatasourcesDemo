package com.yuansong.study.mdd.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "datasource.second")
@Configuration
public class DataSourceConfigSecond extends DataSourceConfigAbstract {

}
